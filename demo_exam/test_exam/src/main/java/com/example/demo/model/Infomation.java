package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "infomation")
public class Infomation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Title is not empty.")
    @Size(min = 5, message = "should not be less than 5.")
    @Size(max = 50, message = "should not be lower than 50.")
    private String title;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    private String content;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date date;
    @NotBlank(message = "Report is not empty.")
    private String report;

    public Infomation() {
    }

    public Infomation(Integer id, String title, Category category, String content, Date date, String report) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.content = content;
        this.date = date;
        this.report = report;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
