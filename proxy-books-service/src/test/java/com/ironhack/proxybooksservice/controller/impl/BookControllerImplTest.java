package com.ironhack.proxybooksservice.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.proxybooksservice.models.Book;
import com.ironhack.proxybooksservice.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerImplTest {

    @Autowired
    private MockMvc mockMvc; // Simular peticiones HTTP
    private final ObjectMapper objectMapper = new ObjectMapper(); // Contruir Objetos JSON a partir de clase de JAVA

    @Autowired
    private BookRepository bookRepository;

    private Book book, book3;

    @BeforeEach
    void setUp() {
        book = new Book(123456789L, "The Lord of the Rings", "J.R.R. Tolkien",
                "Fantasy", 300, "English", 1954, "Minotauro",
                "https://www.amazon.com/Lord-Rings-JRR-Tolkien/dp/0670059029", "Argumento");

        book3 = new Book(45678L, "The Lord of the Rings", "J.R.R. Tolkien",
                "Fantasy", 300, "English", 1954, "Minotauro",
                "https://www.amazon.com/Lord-Rings-JRR-Tolkien/dp/0670059029", "Argumento");


        bookRepository.saveAll(List.of(book));
    }

    @AfterEach
    void tearDown() {
        bookRepository.deleteAll();
    }

    @Test
    void findAllBooks_valid_test() throws Exception {


        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/books")
                        .contentType("application/json")
        ).andReturn();

        assertTrue(result.getResponse().getContentAsString().contains(book.getEan().toString()));
        assertTrue(result.getResponse().getContentAsString().contains(book.getTitle()));
    }

    @Test
    void findBooksByEan_valid_test() throws Exception {
        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                        .get("/books/{ean}", book.getEan())
                        .contentType("application/json")
        ).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains(book.getEan().toString()));
        assertTrue(result.getResponse().getContentAsString().contains(book.getTitle()));
    }




    @Test
    void create() throws Exception {
        Book book2 = new Book(34234234L, "The Lord of the Rings", "J.R.R. Tolkien",
                "Fantasy", 300, "English", 1954, "Minotauro",
                "https://www.amazon.com/Lord-Rings-JRR-Tolkien/dp/0670059029", "Argumento");

        String json = objectMapper.writeValueAsString(book2);

        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                        .post("/books")
                        .contentType("application/json")
                        .content(json)
        ).andReturn();
        assertTrue(result.getResponse().getContentAsString().contains(book2.getEan().toString()));
        assertTrue(result.getResponse().getContentAsString().contains(book2.getTitle()));

    }

    @Test
    void deleteByEan() throws Exception {
        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                        .delete("/books/{ean}", book.getEan())
                        .contentType("application/json")
        ).andReturn();

        assertEquals(204, result.getResponse().getStatus());
        assertEquals(0,result.getResponse().getContentLength());


    }
}
