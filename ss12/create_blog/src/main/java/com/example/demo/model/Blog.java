package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(columnDefinition = "text")
    private String content;

    @Column(columnDefinition = "date")
    private String dateOfWriting;
    private String author;

    @ManyToOne
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(Integer id, String name, String content, String dateOfWriting, String author, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.dateOfWriting = dateOfWriting;
        this.author = author;
        this.category = category;
    }

    public Blog(Integer id, String name, String content, String dateOfWriting, String author) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.dateOfWriting = dateOfWriting;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateOfWriting() {
        return dateOfWriting;
    }

    public void setDateOfWriting(String dateOfWriting) {
        this.dateOfWriting = dateOfWriting;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
