package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.dto.EosStudentDto;
import com.onlyedu.ordermigratedbtool.model.dto.RelativeStateDto;
import com.onlyedu.ordermigratedbtool.model.dto.UserInfoStatisticsDto;
import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import com.onlyedu.ordermigratedbtool.model.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EosStudentMapper {
    int batchInsert(List<EosStudent> eosStudentList);

    List<EosStudent> getAll();

    Integer getEosStudentCount(EosStudentDto eosStudentDto);

    List<EosStudentDto> getEosStudentPage(EosStudentDto eosStudentDto);

    UserInfoStatisticsDto getEosStudentStatistics();

    List<String> getGrade();

    Integer updateRelative(EosStudent eosStudent);

    Integer updateRelativeBatch(List<Integer> ids);

    EosStudentDto getEosStudentByIdWithRelative(Integer eosStudentID);
}