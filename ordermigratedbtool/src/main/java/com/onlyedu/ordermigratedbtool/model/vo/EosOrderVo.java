package com.onlyedu.ordermigratedbtool.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EosOrderVo {
    private Integer id;

    private String orderNo;
    //    private Integer eosStudentID;
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
