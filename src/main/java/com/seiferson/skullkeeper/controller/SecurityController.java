package com.seiferson.skullkeeper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

@RestController
public class SecurityController {

    @GetMapping("/auth")
    @ResponseBody
    public Mono<Map<String, Object>> auth(@AuthenticationPrincipal OAuth2User principal, ServerHttpResponse response){
        return Mono.just(principal.getAttributes());
    }
}
