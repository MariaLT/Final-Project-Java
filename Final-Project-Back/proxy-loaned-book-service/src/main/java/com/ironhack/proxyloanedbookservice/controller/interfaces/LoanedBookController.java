package com.ironhack.proxyloanedbookservice.controller.interfaces;

import com.ironhack.proxyloanedbookservice.controller.dto.LoanedDTO;
import com.ironhack.proxyloanedbookservice.controller.dto.LoanStateDTO;
import com.ironhack.proxyloanedbookservice.controller.dto.PickUpDTO;
import com.ironhack.proxyloanedbookservice.models.LoanedBook;

import java.util.List;

public interface LoanedBookController {

    // USER STUDENT
    LoanedBook loaningBook(LoanedDTO loanedDTO);

    LoanedBook returnBook(Long ean);

    // USER ADMIN

    LoanedBook createLoanedBookRegister(Long ean);
    List<LoanedBook> findAllLoanedBooks();

    LoanedBook findByEan(Long ean);

    List<LoanedBook> findByUserId(Long userId);

    List<LoanedBook> findByLoanState_Available();

    List<LoanedBook> findByLoanState_Lost();

    List<LoanedBook> findByLoanState_Loaned();

    List<LoanedBook> findByLoanState_Overdue();

    LoanedBook updateStatus(Long ean, LoanStateDTO loanStateDTO);

    List<LoanedBook> updateStatusLoans();

    LoanedBook updatePickUp(Long ean, PickUpDTO pickUpDTO);

}
