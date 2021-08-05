package com.example.demo.exceptions;

public enum ErrMsg {
    COMPANY_NAME_EXIST("company name already exist"),
    COMPANY_EMAIL_EXIST("company email already exist"),
    ;

    public String getDesc() {
        return desc;
    }

    private String desc;
    ErrMsg(String desc) {
        this.desc = desc;
    }
}
