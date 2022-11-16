package dev.shegs.blogsite.controllers;

import dev.shegs.blogsite.models.Post;
import dev.shegs.blogsite.models.UserAccount;
import dev.shegs.blogsite.service.PostService;
import dev.shegs.blogsite.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Integer id, Model model){
        Optional<Post> optionalPost = postService.getById(id);

        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post";
        }else {
            return "404";
        }
    }

    @GetMapping("/posts/new")
    public String createNewPost(Model model){
        Optional<UserAccount> optionalUserAccount = userAccountService.findOneByEmail("user.user@shegs.io");
        if (optionalUserAccount.isPresent()){
            Post post = new Post();
            post.setUserAccount(optionalUserAccount.get());
            model.addAttribute("post", post);
            return "post_new";
        }else {
            return "404";
        }
    }

    @PostMapping("/posts/new")
    public String saveNewPost(@ModelAttribute Post post){
        postService.savePost(post);
        return "redirect:/posts/" + post.getId();
    }
}
