package com.studies.keycloak.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class IndexController {

    @GetMapping(path = "/")
    public HashMap<String, String> index() {
        OAuth2User user = ((OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return new HashMap<String, String>() {
            {
                put("Name", user.getAttribute("name"));
                put("Email", user.getAttribute("email"));
            }
        };
    }
}
