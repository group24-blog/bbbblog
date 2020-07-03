package com.group24.demo.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;
    private String commentContent;
    private String commentUser;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    private Blog blog;
    private Date commentTime;
    private int replyId;

    public int getCommentId() {
        return commentId;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public Blog getBlog() {
        return blog;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }
}
