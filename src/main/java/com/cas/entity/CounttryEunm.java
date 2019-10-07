package com.cas.entity;



public enum  CounttryEunm {
    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕");
    private Integer retCode;
    private String retMessage;

    CounttryEunm(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

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

    public static CounttryEunm forEach_countryEnum(int index) {
        //根据index ---_获得值
        CounttryEunm[] myArray = CounttryEunm.values();
        for (CounttryEunm element : myArray) {
            if (index == element.getRetCode()) {
                return element;
            }


        }
        return null;
    }

}