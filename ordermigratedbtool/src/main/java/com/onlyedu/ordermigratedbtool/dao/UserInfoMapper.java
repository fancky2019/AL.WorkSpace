package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.dto.*;
import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    Integer batchInsert(List<UserInfo> userInfoList);

    Integer getUserWithOrderCount(UserInfoDto userInfoDto);

    List<UserInfoDto> getUserWithOrder(UserInfoDto userInfoDto);

    Integer updateRelative(UserInfo userInfo);

    Integer updateUnRelativeBatch(List<Integer> ids);

    Integer updateRelativeBatch(List<Integer> ids);

    UserInfoStatisticsDto getUserInfoStatistics();

    List<Integer> getGrade();

    List<RelativeStateDto> getRelativeState();

    List<UserInfoDto> getUserInfoByGuid(UserInfoDto userInfoDto);

    EosStudent getRelativeEosStudentByUserInfoId(Integer id);

    List<UserInfoEosStudentRelativeDto> getSamePhoneWithEosStudent();

    void syncStudent_CC_RelationShip();

    List<UserInfo> getByPhones(List<String> mobilePhoneList);
}