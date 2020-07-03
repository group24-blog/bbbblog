package com.group24.demo.entity;

import java.util.Date;

public class BriefUser {
    private String account;
    private String name;
    private String photo;
    private String introduction;

    public String getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String getIntroduction(){return introduction;}

    public void setAccount(String account) { this.account = account; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

}
