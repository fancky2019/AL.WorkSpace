package com.onlyedu.ordermigratedbtool.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoRemarkDto implements FieldObject {
    private String userName;
    private String mobilePhone;
    private String adminUserName;
    private String remarks;
    private String userIntention;
    private LocalDateTime addedTime;

    @Override
    public Object[] toFieldObject() {
        String timeStr = "";
        if (addedTime != null) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            timeStr = addedTime.format(dateTimeFormatter);
        }
        String userName = this.userName == null ? "" : this.userName;
        String mobilePhone = this.mobilePhone == null ? "" : this.mobilePhone;
        String adminUserName = this.adminUserName == null ? "" : this.adminUserName;
        String remarks = this.remarks == null ? "" : this.remarks;
        String userIntention = this.userIntention == null ? "" : this.userIntention;

        return new Object[]{userName, mobilePhone, adminUserName, remarks,userIntention, timeStr};
    }

    @Override
    public String[] csvHeaders() {
        return new String[]{"userName", "mobilePhone", "adminUserName", "remarks", "userIntention","addedTime"};
    }
}
