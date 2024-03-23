package com.driver.models;
import ch.qos.logback.core.joran.spi.NoAutoStart;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    public User(){
    }
    public User(Integer id, String name, String pass){
        this.id = id;
        username = name;
        password= pass;
    }
    public User(String name, String pass){
        username = name;
        password= pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Blog> blogList = new ArrayList<>();




    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}