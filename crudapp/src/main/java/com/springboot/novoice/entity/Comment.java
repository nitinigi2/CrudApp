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
    @JoinColumn(name = "user_id")
    private User user;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(){

    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post commentedOn) {
        this.post = commentedOn;
    }

    public Comment(Long id, String comment, User user, Date date, Post post) {
        this.id = id;
        this.comment = comment;
        this.user = user;
        this.date = date;
        this.post = post;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", commentedBy=" + user +
                ", date=" + date +
                ", post=" + post +
                '}';
    }
}
