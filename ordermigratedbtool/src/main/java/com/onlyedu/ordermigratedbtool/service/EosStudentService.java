package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.EosStudentMapper;
import com.onlyedu.ordermigratedbtool.model.dto.EosStudentDto;
import com.onlyedu.ordermigratedbtool.model.dto.RelativeStateDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoStatisticsDto;
import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.model.pojo.PageData;
import com.onlyedu.ordermigratedbtool.model.vo.EosStudentVO;
import com.onlyedu.ordermigratedbtool.model.vo.UserInfoVO;
import com.onlyedu.ordermigratedbtool.utility.ExcelHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EosStudentService {
    private final static Logger logger = LogManager.getLogger(EosStudentService.class);

    @Autowired
    private EosStudentMapper eosStudentMapper;


    public MessageResult<Void> importData(String fileFullName) {
        MessageResult<Void> messageResult = new MessageResult<>();
        try {
            List<EosStudent> eosStudentList = ExcelHelper.getExcelStudentData(fileFullName);
            List<EosStudent> eosStudentDbAllList = eosStudentMapper.getAll();
            //差集：数据库有的就不插入
//            eosStudentList.removeAll(eosStudentDbAllList);
            for (int i = 0; i < eosStudentList.size(); i++) {
                EosStudent current = eosStudentList.get(i);
                for (EosStudent eosStudent : eosStudentDbAllList) {
                    if (current.equals(eosStudent)) {
                        eosStudentList.remove(current);
                        i--;
                        break;
                    }
                }

            }


            //sqlserver最大支持2100个参数，此插入语句有4个参数。
            //每次插入500条确保小于2100最大值。
//            Integer num=2100/4;
            Integer paramCount = 4;
            Integer maxInsertCount = 2099 / paramCount;
            Integer loopCount = eosStudentList.size() / maxInsertCount + 1;
            for (int i = 0; i < loopCount; i++) {
                Integer fromIndex = i * maxInsertCount;
                Integer toIndex = (i + 1) * maxInsertCount;
                toIndex = toIndex > eosStudentList.size() ? eosStudentList.size() : toIndex;
                //subList区间：[)
                List<EosStudent> subList = eosStudentList.subList(fromIndex, toIndex);
                logger.info(MessageFormat.format("Insert form {0} to {1}", fromIndex, toIndex));
                if (subList.size() > 0) {
                    Integer result = eosStudentMapper.batchInsert(subList);
                }
            }

            messageResult.setCode(0);

//            CompletableFuture.runAsync(() ->
//            {
//                autoRelative();
//            });
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }

    public MessageResult<EosStudentVO> getEosStudentByIdWithRelative(Integer eosStudentID) {
        MessageResult<EosStudentVO> message = new MessageResult<>();
        try {
            EosStudentDto eosStudentDto = eosStudentMapper.getEosStudentByIdWithRelative(eosStudentID);
            EosStudentVO eosStudentVO = new EosStudentVO();
            BeanUtils.copyProperties(eosStudentDto, eosStudentVO);
            message.setData(eosStudentVO);
            message.setCode(0);
        } catch (Exception ex) {
            message.setCode(500);
            message.setMessage(ex.getMessage());
            logger.error(ex.toString());
        }
        return message;

    }

    //region


    public MessageResult<PageData<EosStudentVO>> getEosStudentPage(EosStudentDto eosStudentDto) {
        MessageResult<PageData<EosStudentVO>> message = new MessageResult<>();
        try {
            Integer count = eosStudentMapper.getEosStudentCount(eosStudentDto);
            List<EosStudentDto> eosStudentDtoList = eosStudentMapper.getEosStudentPage(eosStudentDto);
            eosStudentDtoList.forEach(p ->
            {
                String userInfoId = p.getUserInfoId();
                if (userInfoId != null && userInfoId != "") {
                    p.setUserInfoId(userInfoId.substring(0, userInfoId.length() - 1));
                }
                if (p.getUserInfoStudentIds() != null && p.getUserInfoStudentIds() != "") {
                    p.setUserInfoStudentIds(p.getUserInfoStudentIds().substring(0, p.getUserInfoStudentIds().length() - 1));
                }
            });
            PageData<EosStudentVO> pageData = new PageData<>();
            pageData.setCount(count);
            message.setCode(0);
            List<EosStudentVO> eosStudentVOList = new ArrayList<>();
            eosStudentDtoList.forEach(p ->
            {
                EosStudentVO eosStudentVO = new EosStudentVO();
                BeanUtils.copyProperties(p, eosStudentVO);
                eosStudentVOList.add(eosStudentVO);
            });
            pageData.setRows(eosStudentVOList);
            message.setData(pageData);
        } catch (Exception ex) {
            message.setCode(500);
            message.setMessage(ex.getMessage());
            logger.error(ex.toString());
        }
        return message;
    }
    //endregion


    public MessageResult<UserInfoStatisticsDto> getEosStudentStatistics() {
        MessageResult<UserInfoStatisticsDto> messageResult = new MessageResult<>();
        try {
            UserInfoStatisticsDto result = eosStudentMapper.getEosStudentStatistics();
            messageResult.setData(result);
            messageResult.setCode(0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }

    public MessageResult<List<String>> getGrade() {
        MessageResult<List<String>> messageResult = new MessageResult<>();
        try {
            List<String> result = eosStudentMapper.getGrade();
            messageResult.setData(result);
            messageResult.setCode(0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }

    public MessageResult<Integer> updateRelative(EosStudent eosStudent) {
        MessageResult<Integer> messageResult = new MessageResult<>();
        try {
//            Integer result = userInfoMapper.updateRelative(userInfo);
//            messageResult.setCode(0);
        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }

}
