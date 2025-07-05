package com.example.querydemo;

import com.example.querydemo.model.Comment;
import com.example.querydemo.model.Post;
import com.example.querydemo.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CustomQueryRunner implements CommandLineRunner {

    private final PostRepository postRepository;

    public CustomQueryRunner(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        setupData();
        runQueries();
    }

    private void setupData() {
        Post p1 = new Post();
        p1.setTitle("Intro to JPA");
        p1.setCategory("Tech");

        Comment c1 = new Comment();
        c1.setText("Great article!");
        c1.setPost(p1);
        p1.getComments().add(c1);

        Post p2 = new Post();
        p2.setTitle("Cooking Basics");
        p2.setCategory("Lifestyle");

        Comment c2 = new Comment();
        c2.setText("Very helpful.");
        c2.setPost(p2);
        p2.getComments().add(c2);

        Post p3 = new Post();
        p3.setTitle("Advanced JPA");
        p3.setCategory("Tech");

        postRepository.save(p1);
        postRepository.save(p2);
        postRepository.save(p3);
    }

    private void runQueries() {
        System.out.println("--- 1. JPQL Query ---");
        System.out.println("Posts with title 'Intro to JPA': " + postRepository.findPostsByTitle("Intro to JPA"));

        System.out.println("\n--- 2. N+1 Problem Demo ---");
        List<Post> posts = postRepository.findAll();
        for (Post post : posts) {
            System.out.println(post + " has " + post.getComments().size() + " comments");
        }

        System.out.println("\n--- 3. FETCH Keyword (JOIN FETCH) ---");
        List<Post> fetchedPosts = postRepository.findAllWithCommentsUsingFetch();
        for (Post post : fetchedPosts) {
            System.out.println(post + " fetched with " + post.getComments().size() + " comments (eagerly)");
        }

        System.out.println("\n--- 4. Aggregate JPQL Query ---");
        System.out.println("Post count by category: " + postRepository.countPostsByCategory());

        System.out.println("\n--- 5. Native SQL Query ---");
        System.out.println("Posts containing 'jpa' keyword: " + postRepository.findPostsByKeywordNative("jpa"));
    }
}
