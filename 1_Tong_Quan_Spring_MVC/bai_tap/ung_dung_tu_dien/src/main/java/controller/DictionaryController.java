package controller;

import dao.DictionaryDao;
import entity.Dictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    DictionaryDao dictionaryDao = new DictionaryDao();

    @GetMapping("")
    public String getLoginPage() {
        return "index";
    }
    @PostMapping("")
    public String dictionary (@RequestParam(name = "text") String a, Model model){
        Dictionary dictionary = dictionaryDao.check(a);
        if (dictionary!=null) {
            model.addAttribute("mess", dictionary.getVie());
            return "index";
        } else {
            model.addAttribute("mess", "Empty dictionary.");
            return "index";
        }
    }
}
