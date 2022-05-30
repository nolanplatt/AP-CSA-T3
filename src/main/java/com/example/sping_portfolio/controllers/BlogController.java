package com.example.sping_portfolio.controllers;

import com.example.sping_portfolio.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog")
    public String viewHomePage(Model model) {
        model.addAttribute("listBlog", blogService.getAllBlogs());
        return "blog/blogmain";
    }
}
