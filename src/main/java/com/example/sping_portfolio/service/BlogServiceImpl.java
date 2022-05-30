package com.example.sping_portfolio.service;

import java.util.List;

import com.example.sping_portfolio.model.Blog;
import com.example.sping_portfolio.repository.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
}
