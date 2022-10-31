package dev.shegs.blogsite.controllers;

import dev.shegs.blogsite.models.UserAccount;
import dev.shegs.blogsite.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount", userAccount);
        return "register";
    }

    @PostMapping("/register")
    public String saveNewUser(@ModelAttribute UserAccount userAccount){
        userAccountService.saveUser(userAccount);
        return "redirect:/";
    }
}
