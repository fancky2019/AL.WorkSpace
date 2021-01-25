package com.onlyedu.ordermigratedbtool.model.dto;

import lombok.Data;

import java.util.List;

/**
 * 多对一，一对多关系
 */
@Data
public class RelativeOrderHeadEosOrderDto {

    private List<Integer> orderHeadIds;
    private List<Integer> eosOrderIds;
}
