package com.example.sping_portfolio.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column
    private String title;
    @Lob
    @Column
    @NotEmpty
    private String content;
    @Column
    private Instant createdOn;
    @Column
    private Instant updatedOn;
    @Column
    @NotBlank
    private String username;

    // getter methods
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public Instant getCreatedOn() {
        return createdOn;
    }
    public Instant getUpdatedOn() {
        return updatedOn;
    }
    public String getUsername() {
        return username;
    }

    // setter methods
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }
    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
