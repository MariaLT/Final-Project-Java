package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("proxy-books-service")
public interface BookClient {

    @GetMapping("/books")
    List<Book> findAllBooks();

    @GetMapping("/books/{ean}")
    Book findBooksByEan(@PathVariable Long ean);

    @PostMapping("/books")
    Book create(@RequestBody Book book);

    @DeleteMapping("/books/{ean}")
    void deleteByEan(@PathVariable Long ean);


}
