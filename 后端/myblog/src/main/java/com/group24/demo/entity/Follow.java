package com.group24.demo.entity;

public class Follow {
    //当前账户
    private String nowAccount;
    //被关注账户
    private int articleId;

    public int getArticleId() {
        return articleId;
    }

    public String getNowAccount() {
        return nowAccount;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setNowAccount(String nowAccount) {
        this.nowAccount = nowAccount;
    }
}
