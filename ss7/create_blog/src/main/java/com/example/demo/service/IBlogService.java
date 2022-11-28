package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    void save(Blog blog);
    Page<Blog> findAll(Pageable pageable);
    Optional findById(Integer id);
    void remove(Integer id);
    Page<Blog> searchNameAndContent(String name,Pageable pageable);
}
