package com.springboot.novoice.entity;

import java.util.Date;

public class Comment {
    private Long id;
    private String comment;
    private User commentedBy;
    private Date date;

    public Comment(Long id, String comment, User commentedBy, Date date) {
        this.id = id;
        this.comment = comment;
        this.commentedBy = commentedBy;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getCommentedBy() {
        return commentedBy;
    }

    public void setCommentedBy(User commentedBy) {
        this.commentedBy = commentedBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", commentedBy=" + commentedBy +
                ", date=" + date +
                '}';
    }
}
