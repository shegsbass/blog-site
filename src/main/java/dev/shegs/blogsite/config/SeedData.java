package dev.shegs.blogsite.config;

import dev.shegs.blogsite.models.Post;
import dev.shegs.blogsite.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0){
            Post post1 = new Post();
            post1.setTitle("Title of Post 1");
            post1.setBody("This is the body for post 1");

            Post post2 = new Post();
            post2.setTitle("This is Post 2");
            post2.setBody("This is the body for post 2");

            postService.savePost(post1);
            postService.savePost(post2);
        }

    }
}
