package com.group24.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int articleId;
    private String articleTitle;
    @ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
    private User articleUser;
    private String articleContent;
    @OneToMany(mappedBy = "blog",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Comment> articleComment = new ArrayList<>();
    private Date articleTime;


    public List<Comment> getArticleComment() {
        return articleComment;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public int getArticleId() {
        return articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public User getArticleUser() {
        return articleUser;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public void setArticleComment(ArrayList<Comment> articleComment) {
        this.articleComment = articleComment;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public void setArticleUser(User articleUser) {
        this.articleUser = articleUser;
    }

}
