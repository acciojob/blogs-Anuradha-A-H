package com.driver.models;


import javax.persistence.*;

@Entity
public class Image{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer imageId;
    private String description;
    private Integer width;
    private Integer hight;

    public Image(String description, Integer width, Integer hight, Blog blog) {
        this.description = description;
        this.width = width;
        this.hight = hight;
        this.blog = blog;
    }

    @ManyToOne
    private Blog blog;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHight() {
        return hight;
    }

    public void setHight(Integer hight) {
        this.hight = hight;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}