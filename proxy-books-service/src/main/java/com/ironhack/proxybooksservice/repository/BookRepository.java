package com.ironhack.proxybooksservice.repository;

import com.ironhack.proxybooksservice.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}

