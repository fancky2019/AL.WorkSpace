package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.dto.StudentOrderDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoDto;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    Integer getUserWithOrderCount(UserInfoDto userInfoDto);

    List<UserInfoDto> getUserWithOrder(UserInfoDto userInfoDto);

    Integer updateRelative(UserInfo userInfo);

}