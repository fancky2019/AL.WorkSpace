package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.*;
import com.onlyedu.ordermigratedbtool.model.dto.FieldObject;
import com.onlyedu.ordermigratedbtool.model.dto.StudentRecordDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoRemarkDto;
import com.onlyedu.ordermigratedbtool.model.entity.*;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.utility.CsvUtil;
import com.onlyedu.ordermigratedbtool.utility.ExcelHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public MessageResult<Void> importData(String fileFullName, String repeatDataFileName) {
        MessageResult<Void> messageResult = new MessageResult<>();
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start("reading data");
            List<StudentRecordDto> studentRecordDtoList = ExcelHelper.getStudentRecord(fileFullName);
            stopWatch.stop();
            Long time1 = stopWatch.getTotalTimeMillis();

            logger.info("reading data:" + time1 + "ms");
            stopWatch.start("removing repeat data");
            //去重
            int maxSize = 2000;
            int maxLoopCount = studentRecordDtoList.size() / 2000 + 1;
            List<UserInfo> getByPhoneList = new ArrayList<>();
            for (int i = 0; i < maxLoopCount; i++) {
                int fromIndex = i * maxSize;
                int toIndex = (i + 1) * maxSize;
                toIndex = toIndex > studentRecordDtoList.size() ? studentRecordDtoList.size() : toIndex;
                //subList区间：[)
                List<String> currentPhoneList = studentRecordDtoList.subList(fromIndex, toIndex).stream().map(p -> p.getPhone()).collect(Collectors.toList());

                if (currentPhoneList.size() > 0) {
                    List<UserInfo> phoneUserinfoList = this.userInfoMapper.getByPhones(currentPhoneList);
                    getByPhoneList.addAll(phoneUserinfoList);
                }

            }
            stopWatch.stop();
            Long time2 = stopWatch.getTotalTimeMillis();

            logger.info("removing repeat data:" + (time2 - time1) + "ms");
            stopWatch.start("notExistList");
            List<StudentRecordDto> notExistList = studentRecordDtoList.stream().filter(p -> !getByPhoneList.stream().anyMatch(m -> m.getMobilePhone().equals(p.getPhone()))).collect(Collectors.toList());
            stopWatch.stop();
            Long time3 = stopWatch.getTotalTimeMillis();

            logger.info("notExistList:" + (time3 - time2) + "ms");
            stopWatch.start("get base data");

            //导入
            List<School> schoolList = schoolMapper.getAll();
            List<ParaDistrict> paraDistrictList = paraDistrictMapper.getAll();
            List<UserIntention> userIntentionList = userIntentionMapper.getAll();
            List<ChannelType> channelTypeMapperList = channelTypeMapper.getAll();
            List<UserCallByWhy> userCallByWhyList = userCallByWhyMapper.getAll();
            stopWatch.stop();
            Long time4 = stopWatch.getTotalTimeMillis();

            logger.info("get base data:" + (time4 - time3) + "ms");
            stopWatch.start("init data");


            List<UserInfo> userInfoList = new ArrayList<>();
            List<UserValid> userValidList = new ArrayList<>();
            List<UserInfoAssign> userInfoAssignList = new ArrayList<>();
            List<UserRemarks> userRemarksList = new ArrayList<>();
            List<CallInRecord> callInRecordList = new ArrayList<>();
            String addBy = "system";
            for (StudentRecordDto p : notExistList) {
                try {
//                    if (p.getName().equals("邓滢滢")) {
//                        int m = 0;
//                    }

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

            stopWatch.stop();
            Long time5 = stopWatch.getTotalTimeMillis();

            logger.info("init data:" + (time5 - time4) + "ms");
            stopWatch.start("insert data");
            //一次插入200条
            int maxInsertCount = 200;
            int loopCount = notExistList.size() / maxInsertCount + 1;
            for (int i = 0; i < loopCount; i++) {
                int fromIndex = i * maxInsertCount;
                int toIndex = (i + 1) * maxInsertCount;
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
            stopWatch.stop();
            Long time6 = stopWatch.getTotalTimeMillis();
            logger.info("insert  data:" + (time6 - time1) + "ms");

            messageResult.setCode(0);
            String importCountStr = "成功导入：" + notExistList.size() + "人；姓名号码重复：" + (studentRecordDtoList.size() - notExistList.size()) + "人";
            List<StudentRecordDto> repeatRecordList = new ArrayList<>(CollectionUtils.removeAll(studentRecordDtoList, notExistList));
            generalRepeatRecordFile(repeatRecordList, repeatDataFileName);
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

    private void generalRepeatRecordFile(List<StudentRecordDto> repeatRecordList, String repeatDataFileName) throws Exception {
        int maxSize = 2000;
        int maxLoopCount = repeatRecordList.size() / 2000 + 1;
        List<UserInfoRemarkDto> userInfoRemarks = new ArrayList<>();
        for (int i = 0; i < maxLoopCount; i++) {
            int fromIndex = i * maxSize;
            int toIndex = (i + 1) * maxSize;
            toIndex = Math.min(repeatRecordList.size(), toIndex);
            //subList区间：[)
            List<String> currentPhoneList = repeatRecordList.subList(fromIndex, toIndex).stream().map(p -> p.getPhone()).collect(Collectors.toList());

            if (currentPhoneList.size() > 0) {
                List<UserInfoRemarkDto> list = this.userInfoMapper.getUserInfoRemarksByPhones(currentPhoneList);
                userInfoRemarks.addAll(list);
            }

        }

//        userInfoRemarks.forEach(p ->
//        {
//            p.setRemarks(StringUtils.trimWhitespace(p.getRemarks()));
//            p.setUserIntention(StringUtils.trimWhitespace(p.getUserIntention()));
//
//            if (StringUtils.hasLength(p.getRemarks())) {
//                p.setRemarks(csvHandlerStr(p.getRemarks()));
//            }
//            if (StringUtils.hasLength(p.getUserIntention())) {
//                p.setUserIntention(csvHandlerStr(p.getRemarks()));
//            }
//        });

        if (org.springframework.util.CollectionUtils.isEmpty(userInfoRemarks)) {
            return;
        }

        userInfoRemarks.forEach(p->
        {
            Optional<StudentRecordDto>  studentRecordDto= repeatRecordList.stream().filter(m-> m.getPhone().equals(StringUtils.trimAllWhitespace(p.getMobilePhone()))).findFirst();
            studentRecordDto.ifPresent(s->
            {
                p.setExcelUserName(s.getName());
            });
        });

//        Optional<?> re= repeatRecordList.stream().filter(p->p.getPhone().equals("13818279739")).findFirst();
//        Optional<?> re1= userInfoRemarks.stream().filter(p->p.getUserName().equals("单畅")).findFirst();

        String[] csvHeaders = userInfoRemarks.get(0).csvHeaders();
        CsvUtil.write(repeatDataFileName, csvHeaders, userInfoRemarks);
    }

    /**
     * 方法名称: csvHandlerStr</br>
     * 方法描述: 处理包含逗号，或者双引号的字段</br>
     * 方法参数: @param forecastName
     * 方法参数: @return  </br>
     * 返回类型: String</br>
     * 抛出异常:</br>
     */
    private String csvHandlerStr(String str) {
        //csv格式如果有逗号，整体用双引号括起来；如果里面还有双引号就替换成两个双引号，这样导出来的格式就不会有问题了
        String tempDescription=str;
        //如果有逗号
        if(str.contains(",")){
            //如果还有双引号，先将双引号转义，避免两边加了双引号后转义错误
            if(str.contains("\"")){
                tempDescription=str.replace("\"", "\"\"");
            }
            //在将逗号转义
            tempDescription="\""+tempDescription+"\"";
        }
        return tempDescription;
    }


}
