package com.example.demo.exceptions;

public enum ErrMsg {
    COMPANY_NAME_EXIST("company name already exist"),
    COMPANY_EMAIL_EXIST("company email already exist"),
    COMPANY_ID_NOT_EXIST("company id does not exist"),
    CUSTOMER_EMAIL_EXIST("customer email already exist"),
    CUSTOMER_ID_NOT_EXIST("customer id does not exist"),
    COMPANY_DOES_NOT_EXIST("company does not exist")
            ;

    public String getDesc() {
        return desc;
    }

    private String desc;
    ErrMsg(String desc) {
        this.desc = desc;
    }
}
