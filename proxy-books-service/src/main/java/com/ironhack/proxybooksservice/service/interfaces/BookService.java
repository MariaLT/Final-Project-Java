package com.ironhack.proxybooksservice.service.interfaces;


import com.ironhack.proxybooksservice.models.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findByEan(Long ean);

    Book create(Book book);

    Book deleteByEan(Long ean);
}
