package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditController {
    @GetMapping("/edit")
    public String reg() {
        return "edit";
    }
}