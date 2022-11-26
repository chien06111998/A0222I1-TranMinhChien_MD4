package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.DETACH)
    List<Infomation> infomations;

    public Category() {
    }

    public Category(Integer id, String name, List<Infomation> infomations) {
        this.id = id;
        this.name = name;
        this.infomations = infomations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Infomation> getInfomations() {
        return infomations;
    }

    public void setInfomations(List<Infomation> infomations) {
        this.infomations = infomations;
    }
}
