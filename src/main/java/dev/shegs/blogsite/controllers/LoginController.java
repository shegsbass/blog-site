package dev.shegs.blogsite.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

}
