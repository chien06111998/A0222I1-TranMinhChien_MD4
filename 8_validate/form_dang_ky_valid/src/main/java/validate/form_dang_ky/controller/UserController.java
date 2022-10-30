package validate.form_dang_ky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import validate.form_dang_ky.model.User;
import validate.form_dang_ky.service.IUserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "1") int page){
        model.addAttribute("userList", userService.findAll(PageRequest.of(page, 1)));
        return "list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", "Add new user failse.");
            return "create";
        }
        userService.create(user);
        model.addAttribute("mess", "Add new user success.");
        return "redirect:/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") Integer id, Model model) {
        Optional<User> user = userService.findById(id);
        model.addAttribute("user", user.orElse(null));
        return "view";
    }
}
