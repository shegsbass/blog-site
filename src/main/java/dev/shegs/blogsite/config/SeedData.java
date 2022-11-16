package dev.shegs.blogsite.config;

import dev.shegs.blogsite.models.Authority;
import dev.shegs.blogsite.models.Post;
import dev.shegs.blogsite.models.UserAccount;
import dev.shegs.blogsite.repository.AuthorityRepository;
import dev.shegs.blogsite.service.PostService;
import dev.shegs.blogsite.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0){

            Authority user = new Authority();
            user.setAuthorityName("ROLE_USER");
            authorityRepository.save(user);

            Authority admin = new Authority();
            admin.setAuthorityName("ROLE_ADMIN");
            authorityRepository.save(admin);

            UserAccount user1 = new UserAccount();
            UserAccount user2 = new UserAccount();

            user1.setFirstName("Test");
            user1.setLastName("User");
            user1.setEmail("user.user@shegs.io");
            user1.setPassword("password");
            Set<Authority> authorities1 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities1::add);
            user1.setAuthorities(authorities1);

            user2.setFirstName("Test");
            user2.setLastName("Admin");
            user2.setEmail("admin.admin@shegs.io");
            user2.setPassword("password");
            Set<Authority> authorities2 = new HashSet<>();
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);
            authorityRepository.findById("ROLE_USER").ifPresent(authorities2::add);
            user2.setAuthorities(authorities2);

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
