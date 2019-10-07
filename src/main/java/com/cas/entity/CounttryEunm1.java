package com.cas.entity;


public enum CounttryEunm1 {
    ONE(1, "秦"), TWO(2, "齐"), THWER(3, "魏");

    private Integer retCode;
    private String retMessage;

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public void setRetMessage(String retMessage) {
        this.retMessage = retMessage;
    }

    CounttryEunm1(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public CounttryEunm1 for_Each(int retCode) {
           //获得枚举的类型;
        CounttryEunm1[] values = CounttryEunm1.values();
        for (CounttryEunm1 value : values) {
            if (value.retCode == retCode) {
                return value;

            }


        }

        return null;
    }
}