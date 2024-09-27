package com.example.vikhlia.controller;

import com.example.vikhlia.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StartPageController {

    @GetMapping("/start")
    public String startPage(Model model) {
        model.addAttribute("user", new User());
        return "start";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute User user, Model model) {

        model.addAttribute("user", user);
        return "submit";
    }
}
