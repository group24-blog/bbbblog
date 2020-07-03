package com.group24.demo.entity;

import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BriefComment {
    private int commentId;
    private String commentContent;
    private String userName;
    private String avater;
    private String userAccount;
    private String commentTime;
    private String replyAccount;
    private String replyName;
    private int replyId;
    private int blogId;

    public int getCommentId() {
        return commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public String getAvater() {
        return avater;
    }

    public int getBlogId() {
        return blogId;
    }

    public String getReplyAccount() {
        return replyAccount;
    }

    public String getReplyName() {
        return replyName;
    }

    public String getUserName() {
        return userName;
    }

    public int getReplyId() {
        return replyId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setCommentTime(Date commentTime) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.commentTime=sdf.format(commentTime);
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public void setReplyAccount(String replyAccount) {
        this.replyAccount = replyAccount;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}