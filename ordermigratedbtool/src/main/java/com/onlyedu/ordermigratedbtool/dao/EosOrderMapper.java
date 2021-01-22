package com.onlyedu.ordermigratedbtool.dao;

import com.onlyedu.ordermigratedbtool.model.dto.EosOrderDto;
import com.onlyedu.ordermigratedbtool.model.dto.StudentOrderDto;
import com.onlyedu.ordermigratedbtool.model.entity.EosOrder;
import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import com.onlyedu.ordermigratedbtool.model.entity.OrderHead;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EosOrderMapper {

    int batchInsert(List<EosOrder> eosOrderList);

    List<EosOrder> getAll();

    int insert(EosOrder record);

//    List<EosOrder> getOrderByStudentId(EosOrder eosOrder);

    Integer getEosOrderCountByStudentId(EosOrderDto eosOrderDto);

    List<EosOrderDto> getEosOrdersByStudentId(EosOrderDto eosOrderDto);

    Integer updateRelative(EosOrder record);
}