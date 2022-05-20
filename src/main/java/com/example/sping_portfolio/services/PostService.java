package com.example.sping_portfolio.services;

import com.example.sping_portfolio.models.Post;
import java.util.List;

// interface for all the methods that a post can do
public interface PostService {
    List<Post> findAll();
    List<Post> findLatest5();
    Post findById(Long id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);
}
