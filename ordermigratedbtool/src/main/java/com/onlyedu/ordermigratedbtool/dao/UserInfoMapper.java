package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.dto.RelativeStateDto;
import com.onlyedu.ordermigratedbtool.model.dto.StudentOrderDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoStatisticsDto;
import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    Integer getUserWithOrderCount(UserInfoDto userInfoDto);

    List<UserInfoDto> getUserWithOrder(UserInfoDto userInfoDto);

    Integer updateRelative(UserInfo userInfo);

    Integer updateUnRelativeBatch(List<Integer> ids);

    UserInfoStatisticsDto getUserInfoStatistics();

    List<Integer> getGrade();

    List<RelativeStateDto> getRelativeState();

    UserInfoDto getUserInfoByGuid(UserInfoDto userInfoDto);

    EosStudent getRelativeEosStudentByUserInfoId(Integer id);

}