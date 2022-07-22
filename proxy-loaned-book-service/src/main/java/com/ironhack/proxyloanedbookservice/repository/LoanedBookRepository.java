package com.ironhack.proxyloanedbookservice.repository;

import com.ironhack.proxyloanedbookservice.models.LoanedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanedBookRepository extends JpaRepository<LoanedBook, Long> {

    Optional<LoanedBook> findByEan(Long ean);
    List<LoanedBook> findListByEan(Long ean);

    List<LoanedBook> findByUserId(Long userId);

    @Query(value = "SELECT ean FROM LoanedBook WHERE loanState = 'AVAILABLE'")
    List<LoanedBook> findByLoanState_Available();

    @Query(value = "SELECT ean FROM LoanedBook WHERE loanState = 'LOST'")
    List<LoanedBook> findByLoanState_Lost();

    @Query(value = "SELECT ean FROM LoanedBook WHERE loanState = 'LOANED'")
    List<LoanedBook> findByLoanState_Loaned();

    @Query(value = "SELECT ean FROM LoanedBook WHERE loanState = 'OVERDUE'")
    List<LoanedBook> findByLoanState_Overdue();


}
