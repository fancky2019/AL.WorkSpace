package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.RelativeOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RelativeOrderMapper {
//    int deleteByPrimaryKey(Integer id);

    int insert(RelativeOrder record);

    int batchInsert(List<RelativeOrder> relativeOrders);

//    int insertSelective(RelativeOrder record);
//
//    RelativeOrder selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(RelativeOrder record);
//
//    int updateByPrimaryKey(RelativeOrder record);
}