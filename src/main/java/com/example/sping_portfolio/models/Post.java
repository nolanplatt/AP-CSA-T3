package com.example.sping_portfolio.models;

import java.util.Date;

public class Post {
    // instance variables
    private Long id;
    private String title;
    private String body;
    private User author;
    private Date date = new Date();

    // setter methods
    public void setId(Long id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setBody(String body) {this.body = body;}
    public void setAuthor(User author) {this.author = author;}
    public void setDate(Date date) {this.date = date;}

    // getter methods
    public Long getId() {return id;}
    public String getTitle() {return title;}
    public String getBody() {return body;}
    public User getAuthor() {return author;}
    public Date getDate() {return date;}

    // constructors
    public Post() {}
    public Post(Long id, String title, String body, User author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    // default toString
    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", title='" + title + '\'' + ", body='" + body + '\'' + ", author='" + author + '\'' + ", date='" + date + '\'' + '}';
    }
}
