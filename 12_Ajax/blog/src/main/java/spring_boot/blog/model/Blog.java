package spring_boot.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "")
    @Column(name = "id_blog")
    private Integer id = 0;
    @Column(name = "name_blog")
    private String name;
    @Column(name = "describe_blog")
    private String describe;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_category")
    private Category categoryId;

    public Blog() {
    }

    public Blog(Integer id, String name, String describe, Category categoryId) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.categoryId = categoryId;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }
}
