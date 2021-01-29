package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import com.onlyedu.ordermigratedbtool.model.entity.RelativeStudent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RelativeStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByUserInfoId(Integer userInfoId);

    int deleteByEosStudentId(Integer eosStudentId);

    int insert(RelativeStudent record);

    List<RelativeStudent> getEosStudentRelative(Integer userInfoId);

    List<RelativeStudent> getEosStudentRelativeUserInfo(Integer eosStudentId);

    int batchInsert(List<RelativeStudent> relativeStudentList);

}