package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    void save(Blog blog);
    List<Blog> findAll();
    Optional findById(Integer id);
    void remove(Integer id);
}
