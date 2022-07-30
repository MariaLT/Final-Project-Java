package com.ironhack.proxybooksservice.service.impl;

import com.ironhack.proxybooksservice.models.Book;
import com.ironhack.proxybooksservice.repository.BookRepository;
import com.ironhack.proxybooksservice.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        List<Book> books = bookRepository.findAll();
        if (books == null || books.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are not found");
        }
        return books;
    }

    @Override
    public Book findByEan(Long ean) {
        Book book = bookRepository.findById(ean).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        return book;
    }

    @Override
    public Book create(Book book) {
        Optional<Book> bookOptional = bookRepository.findById(book.getEan());
        if (bookOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Book already exists");
        }

        return book;
    }

    @Override
    public Book deleteByEan(Long ean) {
        Book book = bookRepository.findById(ean).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        return book;
    }
}
