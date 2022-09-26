package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("")
    public String sandWich() {
        return "index";
    }

    @PostMapping
    public String getSandwich(@RequestParam("spice") String spiceArr, Model model) {
        model.addAttribute("mess", spiceArr);
        return "index";
    }
}
