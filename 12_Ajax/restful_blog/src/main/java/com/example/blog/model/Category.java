package com.example.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameCategory;
    @JsonBackReference
    @OneToMany(mappedBy = "categoryId")
    private List<Blog> blogList;

    public List<Blog> getBlogList() {
        return blogList;
    }

    //    public List<Blog> getBlogList() {
//        return blogList;
//    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public Category() {
    }

    public Category(Integer id, String nameCategory, List<Blog> blogList) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.blogList = blogList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}

