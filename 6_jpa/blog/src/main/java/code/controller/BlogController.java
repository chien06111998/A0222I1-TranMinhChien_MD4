package code.controller;

import code.model.Blog;
import code.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("/list")
     public String display(Model model) {
         model.addAttribute("blogList", blogService.findAll());
         return "list";
     }
     @GetMapping("/create")
     public String formCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
     }

     @PostMapping("/create")
     public String create(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.create(blog);
        model.addAttribute("mess", "Add new Blog success.");
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
        model.addAttribute("blog", blog);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Edit success");
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("nameSearch") String name, Model model) {
        List<Blog> blogList = blogService.search(name);
        model.addAttribute("blogList", blogList);
        return "/list";
    }
}
