package validate.form_dang_ky.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import validate.form_dang_ky.model.User;

import java.util.Optional;

public interface IUserService {
    void create(User user);
    Page findAll(Pageable pageable);

    Optional<User> findById(Integer id);
}
