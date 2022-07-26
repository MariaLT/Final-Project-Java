package com.ironhack.proxyloanedbookservice.service.interfaces;

import com.ironhack.proxyloanedbookservice.controller.dto.LoanedDTO;
import com.ironhack.proxyloanedbookservice.enums.LoanState;
import com.ironhack.proxyloanedbookservice.models.LoanedBook;

import java.util.List;

public interface LoanedBookService {

    // USER STUDENT
    LoanedBook loaningBook(LoanedDTO loanedDTO);

    void returnBook(Long ean);

    // USER ADMIN
    List<LoanedBook> findAll();

    LoanedBook findByEan(Long ean);

    List<LoanedBook> findByUserId(Long userId);

    List<LoanedBook> findByLoanState_Available();

    List<LoanedBook> findByLoanState_Lost();

    List<LoanedBook> findByLoanState_Loaned();

    List<LoanedBook> findByLoanState_Overdue();

    void updateStatus(Long id, LoanState loanState);

    List<LoanedBook> updateStatusLoans();


    LoanedBook createLoanedBook(Long ean);

}
