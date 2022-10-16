package com.seiferson.skullkeeper.controller;

import com.seiferson.skullkeeper.model.Account;
import com.seiferson.skullkeeper.model.Post;
import com.seiferson.skullkeeper.repository.AccountRepository;
import com.seiferson.skullkeeper.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class APIController {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private AccountRepository accountRepo;

    @PostMapping("/posts")
    public Mono<Post> createPost(@AuthenticationPrincipal OAuth2User principal, @RequestBody Post post) {
        post.setAuthor(principal.getAttribute("login"));
        post.setCreated(new Date());
        post.setUpdated(new Date());

        return postRepo.insert(post);
    }

    @GetMapping("/users/{username}")
    public Mono<Account> getAccount(@AuthenticationPrincipal OAuth2User principal, @PathVariable String username) {
        return accountRepo.findByUsername(username);
    }

}
