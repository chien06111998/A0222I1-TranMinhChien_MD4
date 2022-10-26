package spring_boot.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_boot.blog.model.Blog;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
    Page<Blog> findAllByCategoryId_Id(Integer id, Pageable pageable);
}
