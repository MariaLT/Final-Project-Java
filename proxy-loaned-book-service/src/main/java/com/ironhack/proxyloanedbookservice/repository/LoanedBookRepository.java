package com.ironhack.proxyloanedbookservice.repository;

import com.ironhack.proxyloanedbookservice.models.LoanedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanedBookRepository extends JpaRepository<LoanedBook, Long> {


}
