package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.EosOrderMapper;
import com.onlyedu.ordermigratedbtool.dao.OrderHeadMapper;
import com.onlyedu.ordermigratedbtool.dao.RelativeOrderMapper;
import com.onlyedu.ordermigratedbtool.model.dto.*;
import com.onlyedu.ordermigratedbtool.model.entity.*;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.model.pojo.PageData;
import com.onlyedu.ordermigratedbtool.model.vo.StudentOrderVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderHeadService {

    private final static Logger logger = LogManager.getLogger(OrderHeadService.class);

    @Autowired
    private OrderHeadMapper orderHeadMapper;

    @Autowired
    private EosOrderMapper eosOrderMapper;

    @Autowired
    private RelativeOrderMapper relativeOrderMapper;

    //region 获取有订单的学生列表

    public MessageResult<PageData<StudentOrderVO>> getOrderByStudentGuidPage(StudentOrderDto studentOrderDto) {
        MessageResult<PageData<StudentOrderVO>> message = new MessageResult<>();
        try {
            Integer count = orderHeadMapper.getOrderByStudentGuidCount(studentOrderDto);
            PageData<StudentOrderVO> pageData = new PageData<>();
            pageData.setCount(count);

            List<StudentOrderDto> studentOrderDtoList = orderHeadMapper.getOrderByStudentGuid(studentOrderDto);
            List<StudentOrderVO> studentOrderVOList = new ArrayList<>();
            studentOrderDtoList.forEach(p ->
            {
                StudentOrderVO studentOrderVO = new StudentOrderVO();
                BeanUtils.copyProperties(p, studentOrderVO);
                if (p.getEosOrderIds() != null && p.getEosOrderIds() != "") {
                    studentOrderVO.setEosOrderIds(p.getEosOrderIds().substring(0, p.getEosOrderIds().length() - 1));
                }
                if (p.getEosOrderNos() != null && p.getEosOrderNos() != "") {
                    studentOrderVO.setEosOrderNos(p.getEosOrderNos().substring(0, p.getEosOrderNos().length() - 1));
                }

                studentOrderVOList.add(studentOrderVO);
            });
            pageData.setRows(studentOrderVOList);
            message.setCode(0);
            message.setData(pageData);
        } catch (Exception ex) {
            message.setCode(500);
            message.setMessage(ex.getMessage());
            logger.error(ex.toString());
        }
        return message;
    }
    //endregion

    public MessageResult<UserInfoStatisticsDto> getStudentOrderStatistics(StudentOrderDto studentOrderDto) {
        MessageResult<UserInfoStatisticsDto> messageResult = new MessageResult<>();
        try {
            UserInfoStatisticsDto userInfoStatisticsDto = new UserInfoStatisticsDto();
            List<StudentOrderDto> studentOrderDtoList = orderHeadMapper.getOrderByStudentGuid(studentOrderDto);
            Integer totalCount = studentOrderDtoList.size();
            Integer relativeStateCount = studentOrderDtoList.stream().filter(p -> p.getRelativeState()).collect(Collectors.toList()).size();
            Integer unRelativeStateCount = totalCount - relativeStateCount;
            userInfoStatisticsDto.setTotalCount(totalCount);
            userInfoStatisticsDto.setRelativeStateCount(relativeStateCount);
            userInfoStatisticsDto.setUnRelativeStateCount(unRelativeStateCount);

            messageResult.setData(userInfoStatisticsDto);
            messageResult.setCode(0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }


    //region 更新关联装填
    @Transactional(rollbackFor = Exception.class)
    public MessageResult<Void> updateRelative(RelativeOrderHeadEosOrderDto dto) {
        MessageResult<Void> messageResult = new MessageResult<>();
        try {
            List<RelativeOrder> relativeOrderList = new ArrayList<>();
            String userInfoIds = "";
            //网校多对Eos一
            if (dto.getOrderHeadIds().size() > 1) {
                Integer eosOrderId = dto.getEosOrderIds().get(0);
                EosOrder eosOrder = this.eosOrderMapper.selectByPrimaryKey(eosOrderId);
                BigDecimal orderHeadCount = BigDecimal.valueOf(dto.getOrderHeadIds().size());
                relativeOrderList = dto.getOrderHeadIds().stream().map(p ->
                {
                    RelativeOrder relativeOrder = new RelativeOrder();
                    relativeOrder.setEosOrderId(eosOrderId);
                    relativeOrder.setOrderHeadId(p);
                    //平均剩余金额
                    relativeOrder.setEosRemainBalance(eosOrder.getRemainBalance().divide(orderHeadCount, 2, RoundingMode.HALF_UP));
                    return relativeOrder;
                }).collect(Collectors.toList());


            } else {
                //网线一对Eos多
                List<EosOrder> eosOrderList = this.eosOrderMapper.selectByIds(dto.getEosOrderIds());
                BigDecimal sumRemainRemaining = eosOrderList.stream().map(EosOrder::getRemainBalance).reduce(BigDecimal::add).get();
                Integer orderHeadId = dto.getOrderHeadIds().get(0);
                relativeOrderList = dto.getEosOrderIds().stream().map(p ->
                {
                    RelativeOrder relativeOrder = new RelativeOrder();
                    relativeOrder.setOrderHeadId(orderHeadId);
                    relativeOrder.setEosOrderId(p);
                    //剩余金额
                    relativeOrder.setEosRemainBalance(sumRemainRemaining);
                    return relativeOrder;
                }).collect(Collectors.toList());
            }

            //插入RelativeOrder
            Integer result1 = this.relativeOrderMapper.batchInsert(relativeOrderList);
            if (result1 <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                messageResult.setMessage("关联失败");
                messageResult.setCode(500);
                return messageResult;
            }

            //更新OrderHead表关联状态
            Integer result2 = this.orderHeadMapper.updateRelativeBatch(dto.getOrderHeadIds());
            if (result2 <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                messageResult.setMessage("关联失败");
                messageResult.setCode(500);
                return messageResult;
            }

            //更新EosOrder表关联状态
            Integer result3 = this.eosOrderMapper.updateRelativeBatch(dto.getEosOrderIds());
            if (result3 <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                messageResult.setMessage("关联失败");
                messageResult.setCode(500);
                return messageResult;
            }
            messageResult.setCode(0);


        } catch (Exception e) {

            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
            // 手动回滚
            //  TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //如果不抛出异常，将不能自动回滚
            throw e;
        }
        return messageResult;
    }
    //endregion

    //region 解除关联
    @Transactional(rollbackFor = Exception.class)
    public MessageResult<Void> unRelative(OrderHeaderEosOrderUnRelativeDto dto) {
        MessageResult<Void> messageResult = new MessageResult<>();
        try {
            Integer result = 0;
            //OrderHead 解除关联
            if (dto.getUnRelativeType() == 0) {

                //该条关联的EosOrder的关联信息
                List<RelativeOrder> relativeOrderList = this.relativeOrderMapper.getByOrderHeadId(dto.getId());
                //OrderHead多对EosOrder一
                if (relativeOrderList.size() > 1) {
                    //获取EosOrder信息
                    EosOrder eosOrder = this.eosOrderMapper.selectByPrimaryKey(relativeOrderList.get(0).getEosOrderId());
                    //EosOrder还剩余关联的OrderHead个数
                    BigDecimal remainOrderHeadCount = BigDecimal.valueOf(relativeOrderList.size() - 1);
                    //重新计算关联剩余金额
                    BigDecimal avgRemainBalance = eosOrder.getRemainBalance().divide(remainOrderHeadCount, 2, RoundingMode.HALF_UP);
                    //更新剩余关联记录的剩余金额
                    RelativeOrder relativeOrder = new RelativeOrder();
                    relativeOrder.setEosOrderId(relativeOrderList.get(0).getEosOrderId());
                    relativeOrder.setEosRemainBalance(avgRemainBalance);
                    result = this.relativeOrderMapper.updateEosRemainBalanceByEosOrderId(relativeOrder);
                    if (result <= 0) {
                        return setRollBackReturn(messageResult);
                    }
                } else {
                    //OrderHead一对EosOrder一或OrderHead一对EosOrder多
                    //更新EosOrder信息
                    List<Integer> eosOrderIds = new ArrayList<>();
                    eosOrderIds.add(relativeOrderList.get(0).getEosOrderId());
                    result = this.eosOrderMapper.updateUnRelativeBatch(eosOrderIds);
                    if (result <= 0) {
                        return setRollBackReturn(messageResult);
                    }
                }
                //删除RelativeOrder信息
                result = this.relativeOrderMapper.deleteByOrderHeadId(dto.getId());
                if (result <= 0) {
                    return setRollBackReturn(messageResult);
                }
                //更新OrderHead
                OrderHead orderHead = new OrderHead();
                orderHead.setId(dto.getId());
                result = orderHeadMapper.updateUnRelative(orderHead);
                if (result <= 0) {
                    return setRollBackReturn(messageResult);
                }
            } else {
                //EosOrder解除
                //该条关联的OrderHead的关联信息
                List<RelativeOrder> relativeOrderList = this.relativeOrderMapper.getByEosOrderId(dto.getId());
                //EosOrder多对OrderHead一
                if (relativeOrderList.size() > 1) {
                    List<Integer> eosOrderIds = relativeOrderList.stream().map(p -> p.getId()).collect(Collectors.toList());
                    eosOrderIds.remove(dto.getId());
                    //获取该条OrderHead关联的所有EosOrder信息
                    List<EosOrder> eosOrderList = this.eosOrderMapper.selectByIds(eosOrderIds);
                    BigDecimal sumRemainRemaining = eosOrderList.stream().map(EosOrder::getRemainBalance).reduce(BigDecimal::add).get();
                    BigDecimal remainEosOrderCount = BigDecimal.valueOf(relativeOrderList.size() - 1);
                    BigDecimal avgRemainBalance = sumRemainRemaining.divide(remainEosOrderCount, 2, RoundingMode.HALF_UP);
                    //更新剩余关联记录的剩余金额
                    RelativeOrder relativeOrder = new RelativeOrder();
                    relativeOrder.setOrderHeadId(relativeOrderList.get(0).getOrderHeadId());
                    relativeOrder.setEosRemainBalance(avgRemainBalance);
                    result = this.relativeOrderMapper.updateEosRemainBalanceByOrderHeadId(relativeOrder);
                    if (result <= 0) {
                        return setRollBackReturn(messageResult);
                    }
                } else {
                    //EosOrder一对OrderHead一或EosOrder一对OrderHead多
                    //更新OrderHead信息
                    OrderHead orderHead=new OrderHead();
                    if(relativeOrderList.size()==0)
                    {
                        return returnError("没有关联记录！",200);
                    }
                    orderHead.setId(relativeOrderList.get(0).getOrderHeadId());
                    result = this.orderHeadMapper.updateUnRelative(orderHead);
                    if (result <= 0) {
                        return setRollBackReturn(messageResult);
                    }
                }
                //删除RelativeOrder信息
                result = this.relativeOrderMapper.deleteByEosOrderId(dto.getId());
                if (result <= 0) {
                    return setRollBackReturn(messageResult);
                }
                //更新EosOrder
                List<Integer> eosOrderIds = new ArrayList<>();
                eosOrderIds.add(dto.getId());
                result = this.eosOrderMapper.updateUnRelativeBatch(eosOrderIds);
                if (result <= 0) {
                    return setRollBackReturn(messageResult);
                }
            }
            messageResult.setCode(0);
        } catch (Exception e) {

            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
            // 手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            //如果不抛出异常，将不能自动回滚
            // throw e;
        }
        return messageResult;
    }

    private MessageResult<Void> setRollBackReturn(MessageResult<Void> messageResult) {
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        messageResult.setMessage("解除关联失败");
        messageResult.setCode(500);
        return messageResult;
    }
    //endregion

    private  MessageResult<Void> returnError(String errMessage,Integer code)
    {
        MessageResult<Void> result = new MessageResult<>();
        result.setCode(code);
        result.setMessage(errMessage);
        return result;
    }
}
