package code.controller;

import code.model.Music;
import code.service.iMusicService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    iMusicService<Music> musicService;

    @ModelAttribute("music")
    public Music initProduct() {
        return new Music();
    }

    @GetMapping("list")
    public String view(Model model) {
        model.addAttribute("listMusic", musicService.findAll());
        return "/list";
    }

//    @GetMapping("/create")
//    public String formCreate() {
//        return "/create";
//    }
//
//    @PostMapping("/create")
//    public String save(@ModelAttribute("music") Music music, Model model) {
//        musicService.addMusic(music);
//        model.addAttribute("mess", "Add new success.");
//        return "redirect:/list";
//    }
//
//    @GetMapping("/edit{id}")
//    public String edit(@PathVariable("id") int id, Model model) {
//        Music music =musicService.findById(id);
//        model.addAttribute("musicList", music);
//        return "/update";
//    }
//
//    @PostMapping("/edit")
//    public String update(@ModelAttribute("music") Music music) {
//        musicService.edit(music);
//        return "redirect:/music/list";
//    }
//
//    @GetMapping("/search")
//    public String search(@RequestParam("nameSearch") String nameSearch, Model model) {
//        List<Music> musicList = musicService.findByName(nameSearch);
//        if (musicList.isEmpty()) {
//            model.addAttribute("mess", "Not found product.");
//        } else {
//            model.addAttribute("musicList", musicList);
//        }
//        return "/list";
//    }
//
//    @GetMapping("/delete")
//    public String delete(@RequestParam("id") int id) {
//        musicService.delete(id);
//        return "redirect:/music/list";
//    }
//
//    @GetMapping("/detail/{id}")
//    public String detail(@PathVariable("id") int id, Model model) {
//        model.addAttribute("musicList", musicService.findById(id));
//        return "/list";
//    }
}
