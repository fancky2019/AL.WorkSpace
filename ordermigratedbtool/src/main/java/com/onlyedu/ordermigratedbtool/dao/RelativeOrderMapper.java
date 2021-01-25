package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.RelativeOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RelativeOrderMapper {

    int insert(RelativeOrder record);

    int batchInsert(List<RelativeOrder> relativeOrders);

    int deleteByOrderHeadId(Integer orderHeadId);

    List<RelativeOrder> getByOrderHeadId(Integer orderHeadId);

    int deleteByEosOrderId(Integer eosOrderId);

    List<RelativeOrder> getByEosOrderId(Integer eosOrderId);

    int updateEosRemainBalanceByOrderHeadId(RelativeOrder relativeOrder);

    int updateEosRemainBalanceByEosOrderId(RelativeOrder relativeOrder);
//    int insertSelective(RelativeOrder record);
//
//    RelativeOrder selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(RelativeOrder record);
//
//    int updateByPrimaryKey(RelativeOrder record);
}