package com.ironhack.proxybooksservice.repository;

import com.ironhack.proxybooksservice.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//    @Query("SELECT b FROM Book b WHERE b.ean = :ean")
//    Book findByEan(Long ean);

//    Optional<Book> findById(Long ean);
}

