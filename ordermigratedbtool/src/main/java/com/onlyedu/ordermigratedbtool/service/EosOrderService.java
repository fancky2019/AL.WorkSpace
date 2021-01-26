package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.EosOrderMapper;
import com.onlyedu.ordermigratedbtool.dao.EosStudentMapper;
import com.onlyedu.ordermigratedbtool.model.dto.*;
import com.onlyedu.ordermigratedbtool.model.entity.EosOrder;
import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import com.onlyedu.ordermigratedbtool.model.entity.RelativeStudent;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.model.pojo.PageData;
import com.onlyedu.ordermigratedbtool.model.vo.EosOrderVo;
import com.onlyedu.ordermigratedbtool.model.vo.StudentOrderVO;
import com.onlyedu.ordermigratedbtool.utility.ExcelHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EosOrderService {

    private final static Logger logger = LogManager.getLogger(EosOrderService.class);

    @Autowired
    private EosOrderMapper eosOrderMapper;

    public MessageResult<Void> importData(String fileFullName) {
        MessageResult<Void> messageResult = new MessageResult<>();
        try {
            List<EosOrder> eosOrderList = ExcelHelper.getExcelOrderData(fileFullName);
            List<EosOrder> eosOrderDbAllList  = eosOrderMapper.getAll();
            //差集：数据库有的就不插入
//            eosStudentList.removeAll(eosStudentDbAllList);
            for (int i = 0; i < eosOrderList.size(); i++) {
                EosOrder current = eosOrderList.get(i);

                for (EosOrder eosOrder : eosOrderDbAllList) {

                    if(current.getOrderNo().equals("201804036159")&&eosOrder.getOrderNo().equals("201804036159"))
                    {
                        Integer m=0;
                    }
                    if (current.equals(eosOrder)) {
                        eosOrderList.remove(current);
                        i--;
                        break;
                    }
                }

            }


            //sqlserver最大支持2100个参数，此插入语句有4个参数。
            //每次插入500条确保小于2100最大值。
//            Integer num=2100/4;
            Integer paramCount = 8;
            Integer maxInsertCount = 2099 / paramCount;
            Integer loopCount = eosOrderList.size() / maxInsertCount + 1;
            for (int i = 0; i < loopCount; i++) {
                Integer fromIndex = i * maxInsertCount;
                Integer toIndex = (i + 1) * maxInsertCount;
                toIndex = toIndex > eosOrderList.size() ? eosOrderList.size() : toIndex;
                //subList区间：[)
                List<EosOrder> subList = eosOrderList.subList(fromIndex, toIndex);
                logger.info(MessageFormat.format("Insert form {0} to {1}", fromIndex, toIndex));
                if (subList.size() > 0) {
                    //注意mapper的sql,bigDecimal插入数据库会造成小数点丢失精度
                    Integer result = eosOrderMapper.batchInsert(subList);
                }
            }

            messageResult.setCode(0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }


    public MessageResult<PageData<EosOrderVo>> getEosOrderByStudentIdPage(EosOrderDto eosOrderDto) {
        MessageResult<PageData<EosOrderVo>> message = new MessageResult<>();
        try {
            Integer count = eosOrderMapper.getEosOrderCountByStudentId(eosOrderDto);
            PageData<EosOrderVo> pageData = new PageData<>();
            pageData.setCount(count);

            List<EosOrderDto> studentOrderDtoList = eosOrderMapper.getEosOrdersByStudentId(eosOrderDto);
            List<EosOrderVo> eosOrderVoList = new ArrayList<>();
            studentOrderDtoList.forEach(p ->
            {
                EosOrderVo eosOrderVo = new EosOrderVo();
                BeanUtils.copyProperties(p, eosOrderVo);
                if(p.getOrderHeadIds()!=null&&p.getOrderHeadIds()!="") {
                    eosOrderVo.setOrderHeadIds(p.getOrderHeadIds().substring(0,p.getOrderHeadIds().length()-1));
                }
                if(p.getOrderHeadOrderNos()!=null&&p.getOrderHeadOrderNos()!="") {
                    eosOrderVo.setOrderHeadOrderNos(p.getOrderHeadOrderNos().substring(0,p.getOrderHeadOrderNos().length()-1));
                }
                if (p.getOrderHeadProductIds() != null && p.getOrderHeadProductIds() != "") {
                    eosOrderVo.setOrderHeadProductIds(p.getOrderHeadProductIds().substring(0, p.getOrderHeadProductIds().length() - 1));
                }
                eosOrderVoList.add(eosOrderVo);
            });
            pageData.setRows(eosOrderVoList);
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

    public MessageResult<UserInfoStatisticsDto> getEosOrderStatistics(EosOrderDto eosOrderDto) {
        MessageResult<UserInfoStatisticsDto> messageResult = new MessageResult<>();
        try {
            UserInfoStatisticsDto userInfoStatisticsDto = new UserInfoStatisticsDto();
            List<EosOrderDto> studentOrderDtoList = eosOrderMapper.getEosOrdersByStudentId(eosOrderDto);
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


}
