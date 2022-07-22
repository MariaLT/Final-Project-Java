package com.ironhack.proxybooksservice.service.interfaces;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(Long id);

    Book create(Book book);

    Book delete(Book book);
}
