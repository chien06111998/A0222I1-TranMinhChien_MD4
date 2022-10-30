package validate.form_dang_ky.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import validate.form_dang_ky.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Page<User> findAllBy(String name, Pageable pageable);
}
