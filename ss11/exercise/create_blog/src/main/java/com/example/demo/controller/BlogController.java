package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("blogs")
@RestController
public class BlogController {
    @Autowired
    private IBlogService blogService;


    @GetMapping("")
    public ResponseEntity<Iterable<Blog>> findAllBlog(@PageableDefault(page = 0,size = 3) Pageable pageable) {
        Page<Blog> blogList =  blogService.findAll(pageable);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/find-by-category/{category}")
    public ResponseEntity<Iterable<Blog>> findByCategory(@PathVariable("category") Category category,@PageableDefault(page = 0,size = 3) Pageable pageable){
        Page<Blog> blogs = blogService.findByCategory(category,pageable);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


    @GetMapping("/find-by-id/{id}")
    public ResponseEntity findById(@PathVariable("id") int id){
        Blog blog = (Blog) blogService.findById(id).get();
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
