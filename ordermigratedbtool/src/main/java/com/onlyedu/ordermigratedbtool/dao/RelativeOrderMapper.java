package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.entity.OrderHead;
import com.onlyedu.ordermigratedbtool.model.entity.RelativeOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RelativeOrderMapper {

    int insert(RelativeOrder record);

    int batchInsert(List<RelativeOrder> relativeOrders);

    int deleteByOrderHeadProduct(RelativeOrder relativeOrder);

    List<RelativeOrder> getByOrderHeadProduct(RelativeOrder relativeOrder);

    int deleteByEosOrderId(Integer eosOrderId);

    List<RelativeOrder> getByEosOrderId(Integer eosOrderId);

    int updateEosRemainBalanceByOrderHeadProduct(RelativeOrder relativeOrder);

    int updateEosRemainBalanceByEosOrderId(RelativeOrder relativeOrder);

    List<RelativeOrder> getEosProductByOrderProduct(RelativeOrder relativeOrder);

    List<RelativeOrder> getOrderProductByEosProduct(RelativeOrder relativeOrder);

    List<RelativeOrder> getByOrderHeadId(RelativeOrder relativeOrder);

//    int insertSelective(RelativeOrder record);
//
//    RelativeOrder selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(RelativeOrder record);
//
//    int updateByPrimaryKey(RelativeOrder record);
}