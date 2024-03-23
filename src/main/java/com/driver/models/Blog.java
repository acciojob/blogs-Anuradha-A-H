
package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Blog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String associate;
    private Date date;
    public Blog(){

    }

    public Blog(Integer id, String title, String content, String associate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.associate = associate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAssociate() {
        return associate;
    }

    public void setAssociate(String associate) {
        this.associate = associate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    @JoinColumn
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<Image> imageList = new ArrayList<>();
}