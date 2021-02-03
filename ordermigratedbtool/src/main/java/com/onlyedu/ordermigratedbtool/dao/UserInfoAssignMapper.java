package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.UserInfoAssign;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoAssignMapper {

    int insert(UserInfoAssign record);


}