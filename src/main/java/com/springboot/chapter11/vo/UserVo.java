package com.springboot.chapter11.vo;

public class UserVo {
    private Long id;
    private String userName;
    private int sexCode;
    private String sexName;
    private String note;

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getSexCode() {
        return sexCode;
    }

    public String getNote() {
        return note;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSexCode(int sexCode) {
        this.sexCode = sexCode;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
