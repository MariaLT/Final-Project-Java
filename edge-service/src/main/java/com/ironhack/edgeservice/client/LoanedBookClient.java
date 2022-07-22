package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.LoanStateDTO;
import com.ironhack.edgeservice.controller.dto.LoanedBook;
import com.ironhack.edgeservice.controller.dto.LoanedDTO;
import com.ironhack.edgeservice.enums.LoanState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("proxy-loaned-book-service")
public interface LoanedBookClient {

    //    USER STUDENT

    @PostMapping("/loanedBooks")
    LoanedBook loaningBook(@RequestBody LoanedDTO loanedDTO);

    @PatchMapping("/loanedBooks/{ean}")
    void returnBook(@PathVariable Long ean);

    //    USER ADMIN

    @GetMapping("/loanedBooks")
    List<LoanedBook> findAllLoanedBooks();

    @GetMapping("/loanedBooks/{ean}")
    List<LoanedBook> findByEan(@PathVariable Long ean);

    @GetMapping("/loanedBooks/{userId}")
    List<LoanedBook> findByUserId(@PathVariable Long userId);

    @GetMapping("/loanedBooks/available")
    List<LoanedBook> findByLoanState_Available();

    @GetMapping("/loanedBooks/lost")
    List<LoanedBook> findByLoanState_Lost();

    @GetMapping("/loanedBooks/loaned")
    List<LoanedBook> findByLoanState_Loaned();

    @GetMapping("/loanedBooks/overdue")
    List<LoanedBook> findByLoanState_Overdue();

    @PatchMapping("/loanedBooks/{id}/status")
    void updateStatus(@PathVariable Long id, @RequestBody LoanStateDTO loanStateDTO);


    @PatchMapping("/loanedBooks/status")
    void updateStatusLoans();
}
