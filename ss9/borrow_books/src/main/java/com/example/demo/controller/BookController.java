package com.example.demo.controller;
import com.example.demo.model.Book;
import com.example.demo.model.OrderBook;
import com.example.demo.service.IBookService;
import com.example.demo.service.IOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    IOrderBookService orderBookService;

    @GetMapping("create")
    public String showCreateForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/book/create";
    }

    @PostMapping("create")
    public String save(@ModelAttribute("book") Book book, Model model) {
        book.setQuantityAvailable(book.getTotalQuantity());
        bookService.save(book);
        model.addAttribute("mess", "Thêm mới thành công");
        return "/book/create";
    }

    @GetMapping("")
    public String showList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "/book/list";
    }

    @GetMapping("order/{id}")
    public String borrow(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        OrderBook orderBook = new OrderBook();
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent() && book.get().getQuantityAvailable() != 0) {
            long code;
            do {
                code = (long) (Math.random() * (99999 - 10000) + 10000);
            } while (orderBookService.exist(code));
            Set<Book> bookSet;
            if (orderBook.getBookList() != null) {
                bookSet = orderBook.getBookList();
            } else {
                bookSet = new LinkedHashSet<>();
            }
            bookSet.add(book.get());
            orderBook.setBookList(bookSet);
            orderBook.setCode(code);
            orderBookService.save(orderBook);
            book.get().setQuantityAvailable(book.get().getQuantityAvailable() - 1);
            bookService.save(book.get());
            redirectAttributes.addFlashAttribute("mess", "Thuê thành công");
            redirectAttributes.addFlashAttribute("code", code);
            return "redirect:/";
        }
        return "/errorPage";
    }

    @GetMapping("give-book-back")
    public String giveBookBack(@RequestParam long code, RedirectAttributes redirectAttributes) {
        Optional<OrderBook> orderBook = orderBookService.findByCode(code);
        if (orderBook.isPresent() && orderBook.get().isStatus()) {
            orderBook.get().setStatus(false);
            Set<Book> bookList = orderBook.get().getBookList();
            for (Book book : bookList) {
                book.setQuantityAvailable(book.getQuantityAvailable() + 1);
                bookService.save(book);
            }
            orderBookService.save(orderBook.get());
            redirectAttributes.addFlashAttribute("mess", "Trả thành công");
            return "redirect:/";
        }
        if (orderBook.isPresent() && !orderBook.get().isStatus()) {
            redirectAttributes.addFlashAttribute("mess", "mã mượn đã được trả trước đó");
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("mess", "Mã này không đúng");
        return "redirect:/";
    }

    @GetMapping("detail/{id}")
    public String bookDetail(@PathVariable("id") Integer id, Model model) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "/book/detail";
        }
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "/book/edit";
        }
        return "redirect:/";
    }

    @PostMapping("edit")
    public String saveEdit(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {

        book.setQuantityAvailable(book.getTotalQuantity() - book.getOrderBookList().size());
        if (book.getQuantityAvailable()>=0) {
            bookService.save(book);
            redirectAttributes.addFlashAttribute("mess", "Sửa thành công");
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("mess", "Số lượng không đúng");
        return "redirect:/";
    }

    @GetMapping("remove/{id}")
    public String removeBook(@PathVariable("id")Integer id, Model model){
        bookService.removeById(id);
        model.addAttribute("mess", "Xoá thành công");
        return showList(model);
    }
}
