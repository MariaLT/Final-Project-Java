package com.ironhack.proxyloanedbookservice.service.interfaces;

import com.ironhack.proxyloanedbookservice.controller.dto.LoanedDTO;
import com.ironhack.proxyloanedbookservice.enums.LOAN_STATE;
import com.ironhack.proxyloanedbookservice.models.LoanedBook;

import java.util.List;

public interface LoanedBookService {

    // USER STUDENT
    LoanedBook loaningBook(LoanedDTO loanedDTO);

    LoanedBook returnBook(Long ean);

    // USER ADMIN
    List<LoanedBook> findAll();

    LoanedBook findByEan(Long ean);

    List<LoanedBook> findByUserId(Long userId);

    List<LoanedBook> findByLoanState_Available();

    List<LoanedBook> findByLoanState_Lost();

    List<LoanedBook> findByLoanState_Loaned();

    List<LoanedBook> findByLoanState_Overdue();

    LoanedBook updateStatus(Long id, LOAN_STATE LOANSTATE);

    List<LoanedBook> updateStatusLoans();


    LoanedBook createLoanedBook(Long ean);

    public LoanedBook updatePickUp(Long loanedBookId);

}
