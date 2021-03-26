package ru.job4j.forum.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

@Controller
@RequestMapping(value = "/edit")
public class EditController {
    private final PostService postService;
    private final UserService userService;

    public EditController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable int id, Model model) {
        if (id > 0) {
            model.addAttribute("post", postService.findById(id));
        }
        model.addAttribute("user", SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal());
        return "edit";
    }

    @PostMapping("/save/{id}")
    public String save(@PathVariable int id, @RequestParam String name,
                       @RequestParam String description) {
        User user = userService.findByName(SecurityContextHolder
                .getContext()
                .getAuthentication().getName());
        postService.save(id, name, description, user);
        return "redirect:/index";
    }
}
