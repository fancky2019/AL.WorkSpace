package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.*;
import com.onlyedu.ordermigratedbtool.model.dto.StudentRecordDto;
import com.onlyedu.ordermigratedbtool.model.entity.*;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.utility.ExcelHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

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
    private  ChannelTypeMapper channelTypeMapper;
    @Autowired
    private  UserCallByWhyMapper userCallByWhyMapper;
    @Autowired
    private  SysDeptMapper sysDeptMapper;



    public MessageResult<Void> importData(String fileFullName) {
        MessageResult<Void> messageResult = new MessageResult<>();
        try {
            List<StudentRecordDto> eosStudentList = ExcelHelper.getStudentRecord(fileFullName);
            List<School> eosStudentDbAllList = schoolMapper.getAll();
            List<ParaDistrict> paraDistrictList = paraDistrictMapper.getAll();
            List<UserIntention> userIntentionList = userIntentionMapper.getAll();
            List<ChannelType> channelTypeMapperList = channelTypeMapper.getAll();
            List<UserCallByWhy> userCallByWhyList = userCallByWhyMapper.getAll();
//            //差集：数据库有的就不插入
////            eosStudentList.removeAll(eosStudentDbAllList);
//            for (int i = 0; i < eosStudentList.size(); i++) {
//                EosStudent current = eosStudentList.get(i);
//                for (EosStudent eosStudent : eosStudentDbAllList) {
//                    if (current.equals(eosStudent)) {
//                        eosStudentList.remove(current);
//                        i--;
//                        break;
//                    }
//                }
//
//            }


//            //sqlserver最大支持2100个参数，此插入语句有4个参数。
//            //每次插入500条确保小于2100最大值。
////            Integer num=2100/4;
//            Integer paramCount = 4;
//            Integer maxInsertCount = 2099 / paramCount;
//            Integer loopCount = eosStudentList.size() / maxInsertCount + 1;
//            for (int i = 0; i < loopCount; i++) {
//                Integer fromIndex = i * maxInsertCount;
//                Integer toIndex = (i + 1) * maxInsertCount;
//                toIndex = toIndex > eosStudentList.size() ? eosStudentList.size() : toIndex;
//                //subList区间：[)
//                List<EosStudent> subList = eosStudentList.subList(fromIndex, toIndex);
//                logger.info(MessageFormat.format("Insert form {0} to {1}", fromIndex, toIndex));
//                if (subList.size() > 0) {
//                    Integer result = eosStudentMapper.batchInsert(subList);
//                }
//            }

            messageResult.setCode(0);

        } catch (Exception e) {
            logger.error(e.toString());
            messageResult.setCode(500);
            messageResult.setMessage(e.getMessage());
        }
        return messageResult;
    }

}
