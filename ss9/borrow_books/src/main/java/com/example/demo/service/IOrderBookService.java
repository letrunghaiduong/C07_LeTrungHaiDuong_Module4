package com.example.demo.service;

import com.example.demo.model.OrderBook;

import java.util.List;
import java.util.Optional;

public interface IOrderBookService {
    void save(OrderBook orderBook);

    boolean exist(long code);

    Optional<OrderBook> findByCode(long code);

    List<OrderBook> findAll();

    Optional<OrderBook> findById(Integer id);
}
