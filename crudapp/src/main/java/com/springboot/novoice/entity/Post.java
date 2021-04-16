package com.springboot.novoice.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String message;
    @ManyToOne
    private User postedBy;
    private Date date;
    //@OneToMany(mappedBy = "commentedOn")
    @OneToMany(mappedBy = "commentedOn")
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Post(){

    }

    public Post(Long id, String message, User postedBy, Date date, List<Comment> comments) {
        this.id = id;
        this.message = message;
        this.postedBy = postedBy;
        this.date = date;
        this.comments = comments;
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
                ", comments=" + comments +
                '}';
    }
}
