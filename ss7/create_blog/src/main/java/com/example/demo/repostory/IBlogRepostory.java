package com.example.demo.repostory;

import com.example.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepostory extends JpaRepository<Blog,Integer> {
}
