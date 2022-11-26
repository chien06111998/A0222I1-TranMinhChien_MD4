package com.example.blog.service.impl;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.repository.ICategoryRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Blog create(Blog blog) {
        categoryRepository.findAll();
        return  blogRepository.save(blog);
    }


    @Override
    public Optional<Blog> delete(Integer id) {
        blogRepository.deleteById(id);
        return null;
    }

    @Override
    public Page findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }


    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public ResponseEntity<Blog> searchRest(String name, Pageable pageable) {
        return (ResponseEntity<Blog>) blogRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Blog> searchRestBlog(String name, Pageable pageable) {
        return  blogRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Blog> search(String name, Pageable pageable) {
        return blogRepository.findAllByNameContaining(name, pageable);
    }


}
