package com.example.repostory;

import com.example.model.Product;

import java.util.List;

public interface IProductRepostory {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void remove(int id);
}
