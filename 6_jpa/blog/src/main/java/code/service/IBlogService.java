package code.service;

import code.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    void create(Blog blog);

    void update(Blog blog);

    void delete(Integer id);

    List<Blog> findAll();

    Optional<Blog> findById(Integer id);

    List<Blog> search(String name);
}
