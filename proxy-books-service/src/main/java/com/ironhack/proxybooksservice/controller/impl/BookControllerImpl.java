package com.ironhack.proxybooksservice.controller.impl;

import com.ironhack.proxybooksservice.controller.interfaces.BookController;
import com.ironhack.proxybooksservice.models.Book;
import com.ironhack.proxybooksservice.repository.BookRepository;
import com.ironhack.proxybooksservice.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class BookControllerImpl implements BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/books/{ean}")
    @ResponseStatus(HttpStatus.OK)
    public Book findByEan(@PathVariable Long ean) {
        return bookService.findByEan(ean);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(bookService.create(book));
    }

    @DeleteMapping("/books/{ean}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByEan(@PathVariable Long ean) {
        bookRepository.delete(bookService.deleteByEan(ean));
    }
}
