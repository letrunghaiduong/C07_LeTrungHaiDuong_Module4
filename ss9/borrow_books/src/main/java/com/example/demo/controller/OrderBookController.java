package com.example.demo.controller;

import com.example.demo.model.OrderBook;
import com.example.demo.service.IOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("order")
public class OrderBookController {
    @Autowired
    IOrderBookService orderBookService;
    @GetMapping("")
    public String showList(Model model){
        List<OrderBook> orderBookList = orderBookService.findAll();
        model.addAttribute("orderBookList", orderBookList);
        return "/order/list";
    }
    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id")Integer id, Model model){
        Optional<OrderBook> orderBook = orderBookService.findById(id);
        model.addAttribute("orderBook", orderBook.get());
        return"/order/detail";
    }
}
