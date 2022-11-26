package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "1") int page){
        model.addAttribute("blogList", blogService.findAll(PageRequest.of(page, 5)));
        model.addAttribute("categoryList", categoryService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        List<Category> category = categoryService.findAll();
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", category);
        return "create";
    }

//    @PostMapping("/create")
//    public String create(@Valid @ModelAttribute("blog") Blog blog, Model model) {
//        blogService.create(blog);
//        model.addAttribute("mess", "Add new Blog success.");
//        return "redirect:/list";
//    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("blog") Blog blog, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("mess", "không thành công");
            return "/create";
        }else {
            model.addAttribute("mess", "thành công");
            blogService.create(blog);

        }
        return "redirect:/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") Integer id, Model model) {
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog", blog.orElse(null));
        return "view";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete success.");
        return "redirect:/list";
    }
    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable("id") Integer id, Model model) {
        Optional<Blog> blog = blogService.findById(id);
        List<Category> category = categoryService.findAll();
        model.addAttribute("blog", blog);
        model.addAttribute("categories", category);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit success");
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("nameSearch") String name, Pageable pageable, Model model) {
        Page<Blog> blogList = blogService.search(name, pageable);
        model.addAttribute("blogList", blogList);
        return "/list";
    }
}
