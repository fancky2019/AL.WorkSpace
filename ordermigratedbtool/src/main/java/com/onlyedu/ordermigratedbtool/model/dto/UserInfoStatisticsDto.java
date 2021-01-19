package com.onlyedu.ordermigratedbtool.model.dto;

import lombok.Data;

@Data
public class UserInfoStatisticsDto {
    private Integer totalCount;
    private Integer relativeStateCount;
    private Integer unRelativeStateCount;
}
