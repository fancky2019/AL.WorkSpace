package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.School;
import com.onlyedu.ordermigratedbtool.model.entity.UserCallByWhy;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SchoolMapper {
    List<School> getAll();



}