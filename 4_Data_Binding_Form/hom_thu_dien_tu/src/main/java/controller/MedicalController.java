package controller;

import model.Medical;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MedicalController {
    @GetMapping("")
    public String main(Model model) {
        model.addAttribute("medical", new Medical());
        return "index";
    }

    @PostMapping("")
    public String getMedical(@ModelAttribute("medical") Medical medical, Model model) {
        model.addAttribute("language", medical.getLanguage());
        model.addAttribute("pageSize", medical.getPageSize());
        model.addAttribute("spamFilter", medical.getSpamFilter());
        model.addAttribute("signature", medical.getSignature());
        model.addAttribute("mess", "Create medical success");
        return "result";
    }

}
