package com.example.repostory.impl;

import com.example.model.Product;
import com.example.repostory.IProductRepostory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepostory implements IProductRepostory {
    private static final List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Product1",1000000,"abc","Producer1"));
        productList.add(new Product(2,"Product2",2000000,"abc","Producer2"));
        productList.add(new Product(3,"Product3",3000000,"abc","Producer3"));
        productList.add(new Product(4,"Product4",1500000,"abc","Producer4"));
        productList.add(new Product(5,"Product5",4000000,"abc","Producer5"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.add(id,product);
    }
}
