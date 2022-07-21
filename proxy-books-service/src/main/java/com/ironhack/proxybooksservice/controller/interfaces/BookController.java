package com.ironhack.proxybooksservice.controller.interfaces;

import java.awt.print.Book;
import java.util.List;

public interface BookController {

    List<Book> findAll();

    Book findById(Long id);

    Book create(Book book);

    Book delete(Book book);
}
