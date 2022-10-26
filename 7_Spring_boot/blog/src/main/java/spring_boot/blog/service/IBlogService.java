package spring_boot.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring_boot.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    void create(Blog blog);

    void update(Blog blog);

    void delete(Integer id);

    Page findAll(Pageable pageable);

    Optional<Blog> findById(Integer id);

    List<Blog> search(String name, Pageable pageable);
}
