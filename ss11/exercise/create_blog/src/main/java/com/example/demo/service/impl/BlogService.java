package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.IBlogRepository;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Optional findById(Integer id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public Page<Blog> findByCategory(Category category, Pageable pageable) {
        return iBlogRepository.findByCategory(category,pageable);
    }

}
