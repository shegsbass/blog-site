package dev.shegs.blogsite.config;

import dev.shegs.blogsite.models.Post;
import dev.shegs.blogsite.models.UserAccount;
import dev.shegs.blogsite.service.PostService;
import dev.shegs.blogsite.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0){

            UserAccount user1 = new UserAccount();
            UserAccount user2 = new UserAccount();

            user1.setFirstName("user");
            user1.setLastName("user");
            user1.setEmail("user.user@shegs.io");
            user1.setPassword("password");

            user2.setFirstName("Admin");
            user2.setLastName("admin");
            user2.setEmail("admin.admin@shegs.io");
            user2.setPassword("password");

            userAccountService.saveUser(user1);
            userAccountService.saveUser(user2);


            Post post1 = new Post();
            post1.setTitle("Title of Post 1");
            post1.setBody("This is the body for post 1");
            post1.setUserAccount(user1);

            Post post2 = new Post();
            post2.setTitle("This is Post 2");
            post2.setBody("This is the body for post 2");
            post2.setUserAccount(user2);

            postService.savePost(post1);
            postService.savePost(post2);
        }

    }
}
