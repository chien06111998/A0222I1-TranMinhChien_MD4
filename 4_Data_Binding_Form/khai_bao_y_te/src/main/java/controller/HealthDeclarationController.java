package controller;

import model.HealthDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthDeclarationController {
    @GetMapping("")
    public String getHealthDeclaration(Model model) {
        model.addAttribute("healthDeclaration", new HealthDeclaration());
        return "index";
    }


}
