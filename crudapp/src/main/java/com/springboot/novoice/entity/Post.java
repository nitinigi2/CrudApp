package com.springboot.novoice.entity;

import java.util.Date;
import java.util.List;

public class Post {
    private Long id;
    private String message;
    private User postedBy;
    private Date date;
    private List<Comment> comments;

    public Post(){

    }

    public Post(Long id, String message, User postedBy, Date date) {
        this.id = id;
        this.message = message;
        this.postedBy = postedBy;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", postedBy=" + postedBy +
                ", date=" + date +
                '}';
    }
}
