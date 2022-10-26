package spring_boot.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring_boot.blog.model.Blog;
import spring_boot.blog.repository.IBlogRepository;
import spring_boot.blog.service.IBlogService;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);
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
    public List<Blog> search(String name, Pageable pageable) {
        return (List<Blog>) blogRepository.findAllByNameContaining(name, pageable);
    }


}
