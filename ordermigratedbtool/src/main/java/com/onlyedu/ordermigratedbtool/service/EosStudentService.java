package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.EosStudentMapper;
import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import com.onlyedu.ordermigratedbtool.utility.ExcelHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

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
            eosStudentList.removeAll(eosStudentDbAllList);

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
                List<EosStudent> subList = eosStudentList.subList(fromIndex,toIndex );
                logger.info(MessageFormat.format("Insert form {0} to {1}",fromIndex,toIndex));
                if (subList.size() > 0) {
                    Integer result = eosStudentMapper.batchInsert(subList);
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

}
