package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Infomation;
import com.example.demo.service.ICategoryService;
import com.example.demo.service.IInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class InfomationController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IInformationService informationService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("informationList", informationService.findAll());
        return "list";
    }

    @GetMapping("/detail")
    public String details(@RequestParam("id") Integer id, Model model) {
        Optional<Infomation> infomation =informationService.findById(id);
        model.addAttribute("informationList", infomation.orElse(null));
        return "detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id, Model model) {
        informationService.delete(id);
        model.addAttribute("mess", "Delete success.");
        return "redirect:/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Category> category = categoryService.findAll();
        model.addAttribute("categoryList", category);
        model.addAttribute("informationList", new Infomation());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("informationList") Infomation infomation, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Add new failse.");
            model.addAttribute("categoryList", categoryService.findAll());
            return "create";
        }
        informationService.create(infomation);
        model.addAttribute("mess", "Add new success.");
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable ("id") Integer id, Model model) {
        List<Category> category = categoryService.findAll();
        model.addAttribute("categoryList", category);
        model.addAttribute("informationList", informationService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("informationList") Infomation infomation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Edit failse.");
            model.addAttribute("categoryList", categoryService.findAll());
            return "edit";
        }
        informationService.create(infomation);
        model.addAttribute("mess", "Edit success.");
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("titleSearch") String title, Model model){
        model.addAttribute("informationList", informationService.search(title));
        return "list";
    }
}
