package com.example.service.impl;

import com.example.model.Product;
import com.example.repostory.IProductRepostory;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepostory iProductRepostory;
    @Override
    public List<Product> findAll() {
        return iProductRepostory.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepostory.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepostory.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        iProductRepostory.update(id,product);
    }
}
