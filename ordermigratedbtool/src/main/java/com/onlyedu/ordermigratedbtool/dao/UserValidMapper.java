package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.UserValid;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserValidMapper {
    int insert(UserValid record);
}