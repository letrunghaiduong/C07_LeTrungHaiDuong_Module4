package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String listBlog(Model model) {
        model.addAttribute("listBlog", blogService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "New blog created successfully");
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String showEditForm(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Edit successfully");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("deleteById") int deleteById ){
        blogService.remove(deleteById);
        return "redirect:/";
    }

    @GetMapping("/view")
    public String view(@RequestParam Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }
}
