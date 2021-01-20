package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EosStudentMapper {
    int batchInsert(List<EosStudent> eosStudentList);

    List<EosStudent> getAll();
}