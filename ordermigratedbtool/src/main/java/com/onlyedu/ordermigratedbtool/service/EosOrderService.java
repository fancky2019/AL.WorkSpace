package com.onlyedu.ordermigratedbtool.service;

import com.onlyedu.ordermigratedbtool.dao.EosOrderMapper;
import com.onlyedu.ordermigratedbtool.dao.EosStudentMapper;
import com.onlyedu.ordermigratedbtool.model.entity.EosOrder;
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
            Integer paramCount = 7;
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
}
