package com.springboot.novoice.entity;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 2)
    private String name;
    @Past
    private Date dob;
    private String address;
    //@OneToMany(targetEntity = Post.class, mappedBy = "postedBy")
    @OneToMany(mappedBy = "user")
    private List<Post> post;

    public User(){

    }

    public User(String name, Date dob, String address, List<Post> post) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.post = post;
    }

    public User(Long id, String name, Date dob, String address, List<Post> post) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.post = post;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                '}';
    }
}
