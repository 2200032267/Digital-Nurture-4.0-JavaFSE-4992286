package com.example.querydemo.dto;

public class CategoryPostCount {

    private String category;
    private long postCount;

    public CategoryPostCount(String category, long postCount) {
        this.category = category;
        this.postCount = postCount;
    }

    public String getCategory() { return category; }
    public long getPostCount() { return postCount; }

    @Override
    public String toString() {
        return "CategoryPostCount{category='" + category + "', postCount=" + postCount + "}";
    }
}
