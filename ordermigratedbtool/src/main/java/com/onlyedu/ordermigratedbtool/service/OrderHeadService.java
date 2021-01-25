package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.EosOrderMapper;
import com.onlyedu.ordermigratedbtool.dao.OrderHeadMapper;
import com.onlyedu.ordermigratedbtool.dao.RelativeOrderMapper;
import com.onlyedu.ordermigratedbtool.model.dto.*;
import com.onlyedu.ordermigratedbtool.model.entity.*;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.model.pojo.PageData;
import com.onlyedu.ordermigratedbtool.model.vo.StudentOrderVO;
import com.onlyedu.ordermigratedbtool.model.vo.UserInfoVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
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
                if(p.getEosOrderIds()!=null&&p.getEosOrderIds()!="") {
                    studentOrderVO.setEosOrderIds(p.getEosOrderIds().substring(0,p.getEosOrderIds().length()-1));
                }
                if(p.getEosOrderNos()!=null&&p.getEosOrderNos()!="") {
                    studentOrderVO.setEosOrderNos(p.getEosOrderNos().substring(0,p.getEosOrderNos().length()-1));
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
                    relativeOrder.setEosRemainBalance(eosOrder.getRemainRemaining().divide(orderHeadCount,2, RoundingMode.HALF_UP));
                    return relativeOrder;
                }).collect(Collectors.toList());


            } else {
                //网线一对Eos多
                List<EosOrder> eosOrderList = this.eosOrderMapper.selectByIds(dto.getEosOrderIds());
                BigDecimal sumRemainRemaining = eosOrderList.stream().map(EosOrder::getRemainRemaining).reduce(BigDecimal::add).get();
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
//        try {
//            //UserInfo 解除关联
//            if (userInfoStudentUnRelativeDto.getUnRelativeType() == 0) {
//
//                //更新UserInfo
//                UserInfo userInfo = new UserInfo();
//                userInfo.setId(userInfoStudentUnRelativeDto.getId());
//                Integer result = userInfoMapper.updateRelative(userInfo);
//                if (result <= 0) {
//                    return setRollBackReturn(messageResult);
//                }
//                //获取EosStudent关联UserInfo的个数
//                List<RelativeStudent> relativeStudentList = relativeStudentMapper.getEosStudentRelative(userInfoStudentUnRelativeDto.getId());
//                //删除RelativeStudent关联记录
//                Integer delCount = relativeStudentMapper.deleteByUserInfoId(userInfoStudentUnRelativeDto.getId());
//                if (delCount <= 0) {
//                    return setRollBackReturn(messageResult);
//                }
//                if (relativeStudentList.size() == 1) {
//                    //EosStudent关联记录删除完了，更新EosStudent关联状态
//                    RelativeStudent relativeStudent = relativeStudentList.get(0);
//                    EosStudent eosStudent = new EosStudent();
//                    eosStudent.setId(relativeStudent.getEosStudentId());
//                    Integer res = eosStudentMapper.updateRelative(eosStudent);
//                    if (res <= 0) {
//                        return setRollBackReturn(messageResult);
//                    }
//                }
//            } else {
//                //EosStudent解除关联
//                EosStudent eosStudent = new EosStudent();
//                eosStudent.setId(userInfoStudentUnRelativeDto.getId());
//                Integer res = eosStudentMapper.updateRelative(eosStudent);
//                if (res <= 0) {
//                    return setRollBackReturn(messageResult);
//                }
//                //获取EosStudent关联的UserInfo
//                List<RelativeStudent> relativeStudentList = relativeStudentMapper.getEosStudentRelativeUserInfo(userInfoStudentUnRelativeDto.getId());
//                List<Integer> userInfoIds = relativeStudentList.stream().map(p -> p.getUserInfoId()).collect(Collectors.toList());
//                //更新UserInfo未关联
//                Integer re = userInfoMapper.updateUnRelativeBatch(userInfoIds);
//                if (re <= 0) {
//                    return setRollBackReturn(messageResult);
//                }
//                //删除RelativeStudent关联记录
//                Integer delCount = relativeStudentMapper.deleteByEosStudentId(userInfoStudentUnRelativeDto.getId());
//                if (delCount <= 0) {
//                    return setRollBackReturn(messageResult);
//                }
//            }
//            messageResult.setCode(0);
//        } catch (Exception e) {
//
//            logger.error(e.toString());
//            messageResult.setCode(500);
//            messageResult.setMessage(e.getMessage());
//            // 手动回滚
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            //如果不抛出异常，将不能自动回滚
//            // throw e;
//        }
        return messageResult;
    }

    private MessageResult<Void> setRollBackReturn(MessageResult<Void> messageResult) {
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        messageResult.setMessage("解除关联失败");
        messageResult.setCode(500);
        return messageResult;
    }
    //endregion
}
