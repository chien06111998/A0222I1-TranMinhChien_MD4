package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class BlogRestController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

//    @ResponseBody
    @GetMapping()
    public Page<Blog> showList(Model model, @RequestParam(value = "page", defaultValue = "1") int page){
//        model.addAttribute("blogList", blogService.findAll(PageRequest.of(page, 1)));
        model.addAttribute("categoryList", categoryService.findAll());
        return blogService.findAll(PageRequest.of(page, 1));
    }

    @PostMapping()
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.create(blog), HttpStatus.CREATED);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<Blog> view(@PathVariable("id") Integer id) {
        Optional<Blog> blogOp = blogService.findById(id);
        if (!blogOp.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOp.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") Integer id) {
        Optional<Blog> blogOp = blogService.findById(id);
        if (!blogOp.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity<>(blogOp.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> edit(@PathVariable("id") Integer id, @RequestBody Blog blog) {
        Optional<Blog> blogOp = blogService.findById(id);
        if (!blogOp.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOp.get().getId());
        return new ResponseEntity<>(blogService.create(blog), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Blog> search(@RequestParam("nameSearch") String name, Pageable pageable, Model model) {
//        Blog blogList = (Blog) blogService.search(name, pageable);
//        model.addAttribute("blogList", blogList);
        return (ResponseEntity<Blog>) blogService.search(name, pageable);
    }
}
