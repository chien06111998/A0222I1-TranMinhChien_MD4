package spring_boot.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_boot.blog.model.Category;
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
