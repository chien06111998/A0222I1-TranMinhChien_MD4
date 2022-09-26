package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
    @GetMapping("")
    public String getLoginPage() {
        return "index";
    }
    @PostMapping("")
    public String calculator(@RequestParam(name = "numA") double a, @RequestParam(name = "numB") double b, @RequestParam (name = "calculation") String cal, Model model) {
        double result = 0;
        switch (cal) {
            case "addition":
                result = a + b;
                break;
                case "subtraction":
                result = a - b;
                break;
                case "multiplication":
                result = a * b;
                break;
                case "division":
                result = a / b;
                break;
        }
        model.addAttribute("mess", result);
        return "index";
    }
}
