package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {
    @GetMapping("")
    public String getCurrencyConversion() {
        return "index";
    }

    @PostMapping("")
    public String currencyConversion(@RequestParam(name = "usd") double a, Model model) {
        double result = a * 23000;
        model.addAttribute("mess", result);
        return "index";
    }
}
