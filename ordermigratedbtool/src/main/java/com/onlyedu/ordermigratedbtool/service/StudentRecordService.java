package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.*;
import com.onlyedu.ordermigratedbtool.model.dto.StudentRecordDto;
import com.onlyedu.ordermigratedbtool.model.entity.*;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.utility.Commons;
import com.onlyedu.ordermigratedbtool.utility.CsvUtil;
import com.onlyedu.ordermigratedbtool.utility.ExcelHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentRecordService {
    private final static Logger logger = LogManager.getLogger(StudentRecordService.class);
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private CallInRecordMapper callInRecordMapper;

    @Autowired
    private UserInfoAssignMapper userInfoAssignMapper;

    @Autowired
    private UserRemarksMapper userRemarksMapper;

    @Autowired
    private UserValidMapper userValidMapper;

    @Autowired
    private SchoolMapper schoolMapper;
    @Autowired
    private ParaDistrictMapper paraDistrictMapper;
    @Autowired
    private UserIntentionMapper userIntentionMapper;
    @Autowired
    private ChannelTypeMapper channelTypeMapper;
    @Autowired
    private UserCallByWhyMapper userCallByWhyMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Transactional(rollbackFor = Exception.class)
    public MessageResult<Void> importData(String fileFullName,String repeatDataFileName) {
        MessageResult<Void> messageResult = new MessageResult<>();
        try {
            List<StudentRecordDto> studentRecordDtoList = ExcelHelper.getStudentRecord(fileFullName);
            //去重
            Integer maxSize = 2000;
            Integer maxLoopCount = studentRecordDtoList.size() / 2000 + 1;
            List<UserInfo> getByPhoneList = new ArrayList<>();
            for (int i = 0; i < maxLoopCount; i++) {
                Integer fromIndex = i * maxSize;
                Integer toIndex = (i + 1) * maxSize;
                toIndex = toIndex > studentRecordDtoList.size() ? studentRecordDtoList.size() : toIndex;
                //subList区间：[)
                List<String> currentPhoneList = studentRecordDtoList.subList(fromIndex, toIndex).stream().map(p -> p.getPhone()).collect(Collectors.toList());

                if (currentPhoneList.size() > 0) {
                    List<UserInfo> phoneUserinfoList = this.userInfoMapper.getByPhones(currentPhoneList);
                    getByPhoneList.addAll(phoneUserinfoList);
                }

            }

            List<StudentRecordDto> notExistList = studentRecordDtoList.stream().filter(p -> !getByPhoneList.stream().anyMatch(m -> m.getMobilePhone().equals(p.getPhone()))).collect(Collectors.toList());


            //导入
            List<School> schoolList = schoolMapper.getAll();
            List<ParaDistrict> paraDistrictList = paraDistrictMapper.getAll();
            List<UserIntention> userIntentionList = userIntentionMapper.getAll();
            List<ChannelType> channelTypeMapperList = channelTypeMapper.getAll();
            List<UserCallByWhy> userCallByWhyList = userCallByWhyMapper.getAll();

            List<UserInfo> userInfoList = new ArrayList<>();
            List<UserValid> userValidList = new ArrayList<>();
            List<UserInfoAssign> userInfoAssignList = new ArrayList<>();
            List<UserRemarks> userRemarksList = new ArrayList<>();
            List<CallInRecord> callInRecordList = new ArrayList<>();
            String addBy = "ExcelImport";
            for (StudentRecordDto p : notExistList) {
                try {


                    SysUser sysUser = sysUserMapper.selectByAdminUserName(p.getSalesman());

                    School school = schoolList.stream().filter(m -> m.getSchool().equals(p.getSchool())).findFirst().get();
                    ParaDistrict paraDistrict = paraDistrictList.stream().filter(m -> m.getDistrict().equals(p.getDistrict())).findFirst().get();
                    UserIntention userIntention = userIntentionList.stream().filter(m -> m.getUserIntention().equals(p.getEnrollIntention())).findFirst().get();
                    ChannelType channelTypeOne = channelTypeMapperList.stream().filter(m -> m.getTypeName().equals(p.getMarketTypeOne())).findFirst().get();
                    ChannelType channelTypeTwo = channelTypeMapperList.stream().filter(m -> m.getTypeName().equals(p.getMarketTypeTwo()) &&
                            m.getFid().equals(channelTypeOne.getTypeId())).findFirst().get();
                    UserCallByWhy userCallByWhy = userCallByWhyList.stream().filter(m -> m.getWhyCallType().equals(p.getCallIntention())).findFirst().get();

                    p.setSchoolId(school.getGuid());
                    p.setDistrictId(paraDistrict.getGuid());
                    p.setEnrollIntentionId(userIntention.getGuid());
                    p.setMarketTypeOneId(channelTypeOne.getTypeId().toString());
                    p.setMarketTypeTwoId(channelTypeTwo.getTypeId().toString());
                    p.setCallIntentionId(userCallByWhy.getId().toString());

                    String grade = p.getGrade().substring(0, 4);
                    UserInfo userInfo = new UserInfo();
                    userInfo.setStudentId(UUID.randomUUID().toString());
                    userInfo.setUserName(p.getName());
                    userInfo.setMobilePhone(p.getPhone());
                    userInfo.setGrade(grade);
                    userInfo.setDistrictId(p.getDistrictId());
                    userInfo.setSchoolId(p.getSchoolId());
                    userInfo.setUserType("1");
                    userInfo.setUserSourceId("820168d8-2da3-4a06-9ce8-60c704b6e4d0");
                    userInfo.setAddBy(addBy);
                    userInfoList.add(userInfo);

                    UserValid userValid = new UserValid();
                    userValid.setStudentId(userInfo.getStudentId());
                    userValid.setVaildType(3);
                    userValid.setSmallVaildType(20);
                    userValidList.add(userValid);

                    UserInfoAssign userInfoAssign = new UserInfoAssign();
                    userInfoAssign.setStudentId(userInfo.getStudentId());
                    userInfoAssign.setDdlAdmin(sysUser.getSysUserGuid());
                    userInfoAssign.setAddedtime(LocalDateTime.now());
                    userInfoAssign.setUserIntentionId(p.getEnrollIntentionId());
                    userInfoAssignList.add(userInfoAssign);

                    UserRemarks userRemarks = new UserRemarks();
                    userRemarks.setStudentId(userInfo.getStudentId());
                    String remarks = p.getMarketTypeOne() + "-" + p.getMarketTypeTwo();
                    userRemarks.setRemarks(remarks);
                    userRemarks.setUserIntentionId(p.getEnrollIntentionId());
                    userRemarks.setAddBy(addBy);
                    userRemarksList.add(userRemarks);

                    CallInRecord callInRecord = new CallInRecord();
                    callInRecord.setStudentId(userInfo.getStudentId());
                    callInRecord.setComeTime(LocalDateTime.now());
                    callInRecord.setChannelType(p.getMarketTypeTwoId());
                    callInRecord.setIntentionType(Integer.valueOf(p.getCallIntentionId()));
                    callInRecord.setVaildType(20);
                    callInRecord.setAddBy(addBy);
                    callInRecord.setAddTime(LocalDateTime.now());
                    callInRecordList.add(callInRecord);
                } catch (Exception ex) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    logger.error(ex.toString());
                    messageResult.setCode(500);
                    messageResult.setMessage(ex.getMessage());
                    return messageResult;
                }
            }
            ;

            //一次插入200条
            Integer maxInsertCount = 200;
            Integer loopCount = notExistList.size() / maxInsertCount + 1;
            for (int i = 0; i < loopCount; i++) {
                Integer fromIndex = i * maxInsertCount;
                Integer toIndex = (i + 1) * maxInsertCount;
                toIndex = toIndex > notExistList.size() ? notExistList.size() : toIndex;
                //subList区间：[)
                List<UserInfo> currentUserInfoList = userInfoList.subList(fromIndex, toIndex);
                logger.info(MessageFormat.format("Insert form {0} to {1}", fromIndex, toIndex));
                if (currentUserInfoList.size() > 0) {

                    Integer result = this.userInfoMapper.batchInsert(currentUserInfoList);
                    if (result <= 0) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        String msg = "插入UserInfo失败";
                        logger.debug(msg);
                        return MessageResult.returnError(msg, 200);
                    }

                    List<UserValid> currentUserValidList = userValidList.subList(fromIndex, toIndex);
                    result = this.userValidMapper.batchInsert(currentUserValidList);
                    if (result <= 0) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        String msg = "插入UserValid失败";
                        logger.debug(msg);
                        return MessageResult.returnError("插入UserValid失败", 200);
                    }

                    List<UserInfoAssign> currentUserInfoAssignList = userInfoAssignList.subList(fromIndex, toIndex);
                    result = this.userInfoAssignMapper.batchInsert(currentUserInfoAssignList);
                    if (result <= 0) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        String msg = "插入UserInfoAssign失败";
                        logger.debug(msg);
                        return MessageResult.returnError("插入UserInfoAssign失败", 200);
                    }

                    List<UserRemarks> currentUserRemarksList = userRemarksList.subList(fromIndex, toIndex);
                    result = this.userRemarksMapper.batchInsert(currentUserRemarksList);
                    if (result <= 0) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        String msg = "插入UserRemarks失败";
                        logger.debug(msg);
                        return MessageResult.returnError("插入UserRemarks失败", 200);
                    }

                    List<CallInRecord> currentCallInRecordList = callInRecordList.subList(fromIndex, toIndex);
                    result = this.callInRecordMapper.batchInsert(currentCallInRecordList);
                    if (result <= 0) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        String msg = "插入CallInRecord失败";
                        logger.debug(msg);
                        return MessageResult.returnError("插入CallInRecord失败", 200);
                    }

                    try {
                        this.userInfoMapper.syncStudent_CC_RelationShip();
                    } catch (Exception e) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        String msg = "同步Student_CC_RelationShip失败";
                        logger.debug(msg);
                        return MessageResult.returnError("同步Student_CC_RelationShip失败", 200);
                    }


                }
            }
            messageResult.setCode(0);
            String importCountStr = "成功导入：" + notExistList.size() + "人；姓名号码重复：" + (studentRecordDtoList.size() - notExistList.size()) + "人";
            List<StudentRecordDto> repeatRecordList = CollectionUtils.removeAll(studentRecordDtoList, notExistList).stream().collect(Collectors.toList());
            generalRepeatRecordFile(repeatRecordList,repeatDataFileName);
            messageResult.setMessage(importCountStr);
            logger.debug(importCountStr);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }

    private void generalRepeatRecordFile(List<StudentRecordDto> repeatRecordList,String repeatDataFileName) {
        String[] csvHeaders={"name","phone"};
        CsvUtil.write(repeatDataFileName,csvHeaders,repeatRecordList);
    }

}
