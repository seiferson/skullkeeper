package com.seiferson.skullkeeper.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String index(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if(principal != null) {
            return "redirect:/app";
        } else {
            return "index";
        }
    }

    @GetMapping("/app")
    public String app(@AuthenticationPrincipal OAuth2User principal, Model model) {
        model.addAttribute("user", principal.getAttribute("login"));
        return "app";
    }
}
