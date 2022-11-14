package spring_boot.blog.service;

import spring_boot.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
