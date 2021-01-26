package com.onlyedu.ordermigratedbtool.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.onlyedu.ordermigratedbtool.model.pojo.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class EosOrderDto  extends Page {
    private Integer id;

    private String orderNo;
    private Integer eosStudentID;
    private String feeContent;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime orderTime;

    private Integer courseProductID;

    private String courseProductName;

    private BigDecimal orderBalance;

    private BigDecimal remainBalance;

    private Boolean relativeState;

    private String relativeStateStr;

    private String orderHeadOrderNos;

    private String  orderHeadProductIds;

    private String orderHeadIds;

}
