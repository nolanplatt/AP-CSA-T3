package com.example.sping_portfolio.controllers;

import com.example.sping_portfolio.services.*;
import com.example.sping_portfolio.models.Post;
import org.springframework.ui.Model;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Blog {

@Autowired
private PostService postService;

@RequestMapping("/blog")
public String blog(Model model) {
    List<Post> latest5Posts = postService.findLatest5();
    model.addAttribute("latest5posts", latest5Posts);

    List<Post> latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
    model.addAttribute("latest3posts", latest3Posts);
    
    return "blog";
}
}
