package dev.shegs.blogsite.service;

import dev.shegs.blogsite.models.Post;
import dev.shegs.blogsite.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Optional<Post> getById(Integer id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post savePost(Post post) {
        if (post.getId() == null){
            post.setCreatedAt(LocalDateTime.now());
        }

        return postRepository.save(post);
    }
}
