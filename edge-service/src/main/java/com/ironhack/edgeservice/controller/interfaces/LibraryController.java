package com.ironhack.edgeservice.controller.interfaces;

import com.ironhack.edgeservice.controller.dto.Book;
import com.ironhack.edgeservice.controller.dto.LoanStateDTO;
import com.ironhack.edgeservice.controller.dto.LoanedBook;
import com.ironhack.edgeservice.controller.dto.LoanedDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface LibraryController {
    // ----------------------------------//
    //          BOOKS SERVICE            //
    // ----------------------------------//

    List<Book> findAllBooks();

    Book findBooksByEan(Long ean);

    Book create(Book book);

    void deleteByEan(Long ean);


    // ----------------------------------//
    //       LOANED BOOK SERVICE         //
    // ----------------------------------//

    //    USER STUDENT

    LoanedBook loaningBook(LoanedDTO loanedDTO);

    void returnBook(Long ean);

    //    USER ADMIN

    List<LoanedBook> findAllLoanedBooks();

    LoanedBook findByEan(Long ean);

    List<LoanedBook> findByUserId(Long userId);

    List<LoanedBook> findByLoanState_Available();

    List<LoanedBook> findByLoanState_Lost();

    List<LoanedBook> findByLoanState_Loaned();

    List<LoanedBook> findByLoanState_Overdue();

    void updateStatus(Long id, LoanStateDTO loanStateDTO);

    void updateStatusLoans();
}
