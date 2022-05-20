package com.example.sping_portfolio.services;

import com.example.sping_portfolio.models.Post;
import com.example.sping_portfolio.models.User;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceStubImpl implements PostService{
    private List<Post> posts = new ArrayList<Post>() {{
        // sample data hardcoded into the blog
        add(new Post(1L, "Post 1", "<p>Hello.</p><p>World.</p>", null) );
        add(new Post(2L, "Post 2", "Content:<ul><li>yo</li><li>what's up</li></p>", new User(10L, "jmort10", "John Mort")) );
        add(new Post(3L, "Post 3", "<p>hi</p>", new User(10L, "exuser2", null)) );
        add(new Post(4L, "Post 4", "<p>example stuff</p>", null));
        add(new Post(5L, "Post 5", "<p>other examples</p>", null));
        add(new Post(6L, "Post 6", "<p>more examples</p>", null));
    }};

    // implementing methods from the interface
    @Override
    public List<Post> findAll() {
        return this.posts;
    }
    @Override
    public List<Post> findLatest5() {
        return this.posts.stream().sorted( (a,b) -> b.getDate().compareTo(a.getDate()) ).limit(5).collect(Collectors.toList());
    }
    @Override
    public Post findById(Long id) {
        return this.posts.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElse(null);
    }
    @Override
    public Post create(Post post) {
        post.setId(this.posts.stream().mapToLong(p -> p.getId()).max().getAsLong() + 1);
        this.posts.add(post);
        return post;
    }
    @Override
    public Post edit(Post post) {
        for (int i = 0; i < this.posts.size(); i++) {
            if (Objects.equals(this.posts.get(i).getId(), post.getId())) {
                this.posts.set(i, post);
                return post;
            }
        }
        throw new RuntimeException("Post not found: " + post.getId());
    }
    @Override
    public void deleteById(Long id) {
        for (int i = 0; i < this.posts.size(); i++) {
            if (Objects.equals(this.posts.get(i).getId(), id)) {
                this.posts.remove(i);
                return;
            }
        }
        throw new RuntimeException("Post not found: " + id);
    }
}
