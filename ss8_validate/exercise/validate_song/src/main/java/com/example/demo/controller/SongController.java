package com.example.demo.controller;

import com.example.demo.model.Song;
import com.example.demo.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String listBlog(Model model) {
        model.addAttribute("songList", songService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("song") Song song, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            return "create";
        }
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "New song created successfully");
        return "redirect:/create";
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam Integer id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateSong(@ModelAttribute("song") Song song, RedirectAttributes redirectAttributes) {
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Edit successfully");
        return "redirect:/";
    }
}
