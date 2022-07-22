package com.ironhack.proxyloanedbookservice.controller.interfaces;

import com.ironhack.proxyloanedbookservice.controller.dto.LoanedDTO;
import com.ironhack.proxyloanedbookservice.models.LoanedBook;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanedBookController {

    // USER STUDENT
    LoanedBook loaningBook(LoanedDTO loanedDTO);

    void returnBook(Long ean);

    // USER ADMIN
    List<LoanedBook> findAll();

    List<LoanedBook> findByEan(Long ean);

    List<LoanedBook> findByUserId(Long userId);

    List<LoanedBook> findByLoanState_Available();

    List<LoanedBook> findByLoanState_Lost();

    List<LoanedBook> findByLoanState_Loaned();

    List<LoanedBook> findByLoanState_Overdue();

}
