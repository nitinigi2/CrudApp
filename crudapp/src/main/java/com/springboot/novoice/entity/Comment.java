package com.springboot.novoice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COMMENT")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String comment;
    @ManyToOne
    private User commentedBy;
    private Date date;
    @ManyToOne
    private Post commentedOn;

    public Comment(){

    }

    public Post getPost() {
        return commentedOn;
    }

    public void setPost(Post commentedOn) {
        this.commentedOn = commentedOn;
    }

    public Comment(Long id, String comment, User commentedBy, Date date, Post commentedOn) {
        this.id = id;
        this.comment = comment;
        this.commentedBy = commentedBy;
        this.date = date;
        this.commentedOn = commentedOn;
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
                ", post=" + commentedOn +
                '}';
    }
}
