package com.example.demo.repository;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findByCategory (Category category, Pageable pageable);
}
