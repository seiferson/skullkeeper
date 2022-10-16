package com.seiferson.skullkeeper.controller;

import com.seiferson.skullkeeper.model.Account;
import com.seiferson.skullkeeper.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class AppController {

    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private AccountRepository accountRepo;

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
        accountRepo.existsByUsername(principal.getAttribute("login")).subscribe(exists -> {
            if(!exists) {
                Account accnt = new Account();
                accnt.setJoined(new Date());
                accnt.setUsername(principal.getAttribute("login"));
                accnt.setNickname(principal.getAttribute("login"));
                accnt.setSubscriptions(new ArrayList<>());

                accountRepo.insert(accnt).subscribe(accnt1 -> {
                    logger.info(accnt1.toString());
                });
            }
        });

        model.addAttribute("user", principal.getAttribute("login"));
        return "app";
    }
}
