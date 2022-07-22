package com.ironhack.proxybooksservice.service.impl;

import com.ironhack.proxybooksservice.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    @Override
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
