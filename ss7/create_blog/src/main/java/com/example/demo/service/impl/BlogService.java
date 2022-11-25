package com.example.demo.service.impl;

import com.example.demo.model.Blog;
import com.example.demo.repostory.IBlogRepostory;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepostory iBlogRepostory;

    @Override
    public void save(Blog blog) {
        iBlogRepostory.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepostory.findAll();
    }

    @Override
    public Optional findById(Integer id) {
        return iBlogRepostory.findById(id);
    }

    @Override
    public void remove(Integer id) {
        iBlogRepostory.deleteById(id);
    }
}
