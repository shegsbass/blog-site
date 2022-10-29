package dev.shegs.blogsite.service;

import dev.shegs.blogsite.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Optional<Post> getById(Integer id);

    List<Post> getAll();
    Post savePost(Post post);
}
