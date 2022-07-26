package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.LoanStateDTO;
import com.ironhack.edgeservice.controller.dto.LoanedBook;
import com.ironhack.edgeservice.controller.dto.LoanedDTO;
import com.ironhack.edgeservice.controller.dto.PickUpDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("proxy-loaned-book-service")
public interface LoanedBookClient {

    //    USER STUDENT

    @PostMapping("/loanedBooks")
    LoanedBook loaningBook(@RequestBody LoanedDTO loanedDTO);

    @GetMapping("/loanedBooks/return/{ean}")
    public LoanedBook returnBook(@PathVariable Long ean);

    //    USER ADMIN
    @PostMapping("/loanedBooks/create")
    public LoanedBook createLoanedBookRegister(@RequestBody Long ean);

    @GetMapping("/loanedBooks")
    List<LoanedBook> findAllLoanedBooks();

    @GetMapping("/loanedBooks/{ean}")
    LoanedBook findByEan(@PathVariable Long ean);

    // No esta en el servicio de angular
    @GetMapping("/loanedBooks/user/{userId}")
    List<LoanedBook> findByUserId(@PathVariable Long userId);

    @GetMapping("/loanedBooks/available")
    List<LoanedBook> findByLoanState_Available();

    @GetMapping("/loanedBooks/lost")
    List<LoanedBook> findByLoanState_Lost();

    @GetMapping("/loanedBooks/loaned")
    List<LoanedBook> findByLoanState_Loaned();

    @GetMapping("/loanedBooks/overdue")
    List<LoanedBook> findByLoanState_Overdue();

    @PatchMapping("/loanedBooks/{ean}/status")
    LoanedBook updateStatus(@PathVariable Long ean, @RequestBody LoanStateDTO loanStateDTO);

    @GetMapping("/loanedBooks/status")
    List<LoanedBook> updateStatusLoans();

    @PutMapping("/loanedBooks/pickUp/{ean}")
    public LoanedBook updatePickUp(@PathVariable Long ean, @RequestBody PickUpDTO pickUpDTO);
}
