package com.example.querydemo.model;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment() {}

    // Getters and Setters
    public Long getId() { return id; }
    public String getText() { return text; }
    public Post getPost() { return post; }

    public void setId(Long id) { this.id = id; }
    public void setText(String text) { this.text = text; }
    public void setPost(Post post) { this.post = post; }

    @Override
    public String toString() {
        return "Comment{id=" + id + ", text='" + text + "'}";
    }
}
