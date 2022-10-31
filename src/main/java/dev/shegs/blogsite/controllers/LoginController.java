package dev.shegs.blogsite.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
}
