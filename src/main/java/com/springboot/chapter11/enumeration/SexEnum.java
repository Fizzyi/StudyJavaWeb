package com.springboot.chapter11.enumeration;

public enum SexEnum {
    MALE(1, "男"),
    FEMALE(2, "女");
    private int code;
    private String name;

    SexEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static SexEnum getEnumById(int id) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.getId() == id) {
                return sex;
            }
        }
        return null;
    }
    public static SexEnum getSexEnum(int code) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.getCode() == code) {
                return sex;
            }
        }
        return null;
    }

    public int getCode() {
        return this.code;
    }

    public int getId() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }


}
