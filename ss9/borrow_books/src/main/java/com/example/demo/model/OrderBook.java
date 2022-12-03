package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class OrderBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private long code;
    private boolean status= true;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Book> bookList;

    public OrderBook() {
    }

    public OrderBook(Integer id, long code, boolean status, Set<Book> bookList) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.bookList = bookList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Book> getBookList() {
        return bookList;
    }

    public void setBookList(Set<Book> bookList) {
        this.bookList = bookList;
    }
}
