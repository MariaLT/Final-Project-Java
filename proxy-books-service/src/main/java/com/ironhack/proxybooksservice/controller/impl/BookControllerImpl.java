package com.ironhack.proxybooksservice.controller.impl;

import com.ironhack.proxybooksservice.controller.interfaces.BookController;
import com.ironhack.proxybooksservice.repository.BookRepository;
import com.ironhack.proxybooksservice.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
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
        return null;
    }

    @Override
    public Book findById(Long id) {
        return null;
    }

    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public Book delete(Book book) {
        return null;
    }
}
