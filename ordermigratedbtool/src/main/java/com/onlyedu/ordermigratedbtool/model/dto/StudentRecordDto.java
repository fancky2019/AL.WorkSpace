package com.onlyedu.ordermigratedbtool.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRecordDto  implements FieldObject{
    private  String name;
    private  String phone;
    private  String grade;
    private  String district;
    private  String districtId;
    private  String school;
    private  String schoolId;
    private  String marketTypeOne;
    private  String marketTypeOneId;
    private  String marketTypeTwo;
    private  String marketTypeTwoId;
    private  String callIntention;
    private  String callIntentionId;
    /**
     * 报名意向
     */
    private  String enrollIntention;
    private  String enrollIntentionId;
    private  String saleGroup;
    private  String saleGroupId;
    private  String salesman;
    private  String salesmanId;

    @Override
    public Object[] toFieldObject()
    {
        Object[] objects= {this.name,this.phone};
        return  objects;
    }

    @Override
    public String[] csvHeaders() {
        return new String[]{"name","phone"};
    }
}
