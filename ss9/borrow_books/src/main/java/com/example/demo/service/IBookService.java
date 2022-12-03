package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    void save(Book book);

    List<Book> findAll();

    Optional<Book> findById(Integer id);

    void borrow(Book book, long code);

    void removeById(Integer id);
}