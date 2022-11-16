package dev.shegs.blogsite.service;

import dev.shegs.blogsite.models.Post;
import dev.shegs.blogsite.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Optional<Post> getById(Integer id);

    List<Post> getAll();
    Post savePost(Post post);

    void delete(Post post);
}
