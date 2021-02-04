package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.CallInRecord;
import com.onlyedu.ordermigratedbtool.model.entity.ChannelType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CallInRecordMapper {
    int batchInsert(List<CallInRecord> callInRecordList);
}