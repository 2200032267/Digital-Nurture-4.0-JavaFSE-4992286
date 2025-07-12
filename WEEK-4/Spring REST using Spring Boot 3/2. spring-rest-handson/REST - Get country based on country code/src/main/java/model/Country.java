package com.cognizant.spring_learn.model;

public class Country {
    private String code;
    private String name;

    // Constructor
    public Country() {}

    // Getters & Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Country{" + "code='" + code + '\'' + ", name='" + name + '\'' + '}';
    }
}
