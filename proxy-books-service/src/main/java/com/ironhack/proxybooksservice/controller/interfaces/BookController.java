package com.ironhack.proxybooksservice.controller.interfaces;


import com.ironhack.proxybooksservice.models.Book;

import java.util.List;

public interface BookController {

    List<Book> findAllBooks();

    Book findBooksByEan(Long ean);

    Book create(Book book);

    void deleteByEan(Long ean);
}
