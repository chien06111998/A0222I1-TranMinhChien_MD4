package spring_boot.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring_boot.blog.model.Category;
import spring_boot.blog.repository.ICategoryRepository;
import spring_boot.blog.service.ICategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

//    @Override
//    public Page findAll(Pageable pageable) {
//        return categoryRepository.findAll(pageable);
//    }
}
