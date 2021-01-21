package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.RelativeStudent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RelativeStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RelativeStudent record);

}