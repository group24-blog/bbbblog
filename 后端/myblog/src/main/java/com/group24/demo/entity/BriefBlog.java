package com.group24.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BriefBlog {
    //文章ID
    private int articleId;
    //文章标题
    private String articleTitle;
    //作者账户
    private String articleUserAccount;
    //作者昵称
    private String articleUserName;
    //格式化创作时间
    //格式 yyyy-MM-dd HH:mm:ss
    private String articleTime;
    //内容
    private String articleContent;
    //粉丝数
    private int followers;
    //关注数量
    private int subscribers;
    //博客数
    private int blogNum;
    //照片
    private String photo;
    //当前博主是否已被关注
    private boolean ifFollow;

    private List<BriefComment> briefCommentList;

    public String getArticleTime() {
        return articleTime;
    }

    public int getArticleId() {
        return articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleUserAccount() {
        return articleUserAccount;
    }

    public String getArticleContent(){return articleContent;}

    public int getFollowers() {
        return followers;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public boolean getIfFollow(){return ifFollow;}

    public String getPhoto() {
        return photo;
    }

    public String getArticleUserName() {
        return articleUserName;
    }

    public int getBlogNum() {
        return blogNum;
    }

    public List<BriefComment> getBriefCommentList() {
        return briefCommentList;
    }

    public void setArticleTitle(String articalTitle) {
        this.articleTitle = articalTitle;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setArticleTime(Date date) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.articleTime=sdf.format(date);
    }

    public void setArticleUserAccount(String articleUserAccount) {
        this.articleUserAccount = articleUserAccount;
    }

    public void setArticleContent(String articleContent){this.articleContent=articleContent;}

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }


    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setArticleUserName(String articleUserName) {
        this.articleUserName = articleUserName;
    }

    public void setBlogNum(int blogNum) {
        this.blogNum = blogNum;
    }

    public void setBriefCommentList(List<BriefComment> briefCommentList) {
        this.briefCommentList = briefCommentList;
    }

    public void setIfFollow(boolean ifFollow){this.ifFollow=ifFollow;}
}