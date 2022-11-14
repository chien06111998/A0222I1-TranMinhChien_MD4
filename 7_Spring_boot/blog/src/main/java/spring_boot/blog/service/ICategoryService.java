package spring_boot.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring_boot.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
//    Page findAll(Pageable pageable);
}
