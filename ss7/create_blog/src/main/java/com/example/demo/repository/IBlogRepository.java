package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value= "select * from blog b where b.name like concat('%',:name,'%') or b.content like concat('%',:content,'%') order by author",
    countQuery = "select * from blog b where b.name like concat('%',:name,'%') or b.content like concat('%',:content,'%') order by author", nativeQuery = true)
    Page<Blog> searchNameAndContent(@Param("name") String name, @Param("content") String content, Pageable pageable);
}
