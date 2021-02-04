package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.UserInfoAssign;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoAssignMapper {
    int batchInsert(List<UserInfoAssign> userInfoAssignList);
}