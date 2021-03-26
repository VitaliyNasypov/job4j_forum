package ru.job4j.forum.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.CommentService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

@Controller
@RequestMapping(value = "/post")
public class PostController {
    private final PostService postService;
    private final CommentService commentService;
    private final UserService userService;

    public PostController(PostService postService, CommentService commentService,
                          UserService userService) {
        this.postService = postService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String post(@PathVariable int id, Model model) {
        System.out.println(postService.findById(id).getName());
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("user", SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal());
        return "post";
    }

    @PostMapping("/add/{id}")
    public String add(@PathVariable int id, @RequestParam(value = "comment") String comment) {
        User user = userService.findByName(SecurityContextHolder
                .getContext()
                .getAuthentication().getName());
        commentService.save(id, comment, user);
        return "redirect:/post/" + id;
    }
}
