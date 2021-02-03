package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.UserRemarks;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRemarksMapper {

    int insert(UserRemarks record);


}