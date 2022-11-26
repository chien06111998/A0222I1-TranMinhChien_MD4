package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IBlogService {
    Blog create(Blog blog);

    Optional<Blog> delete(Integer id);

    Page findAll(Pageable pageable);

    Optional<Blog> findById(Integer id);

    ResponseEntity<Blog> searchRest(String name, Pageable pageable);

    Page<Blog> search(String name, Pageable pageable);
    public Page<Blog> searchRestBlog(String name, Pageable pageable);

}
