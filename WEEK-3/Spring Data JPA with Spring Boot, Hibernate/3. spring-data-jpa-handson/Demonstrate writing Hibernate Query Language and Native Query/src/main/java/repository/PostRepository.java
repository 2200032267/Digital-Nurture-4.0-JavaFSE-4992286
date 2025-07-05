package com.example.querydemo.repository;

import com.example.querydemo.dto.CategoryPostCount;
import com.example.querydemo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.title = :title")
    List<Post> findPostsByTitle(String title);

    @Query("SELECT DISTINCT p FROM Post p LEFT JOIN FETCH p.comments")
    List<Post> findAllWithCommentsUsingFetch();

    @Query("SELECT new com.example.querydemo.dto.CategoryPostCount(p.category, COUNT(p)) FROM Post p GROUP BY p.category")
    List<CategoryPostCount> countPostsByCategory();

    @Query(value = "SELECT * FROM post WHERE LOWER(title) LIKE %?1%", nativeQuery = true)
    List<Post> findPostsByKeywordNative(String keyword);
}
