package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.UserValid;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserValidMapper {
    int batchInsert(List<UserValid> userValidList);
}