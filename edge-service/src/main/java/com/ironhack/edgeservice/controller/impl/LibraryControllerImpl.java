package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.client.BookClient;
import com.ironhack.edgeservice.client.LoanedBookClient;
import com.ironhack.edgeservice.controller.dto.Book;
import com.ironhack.edgeservice.controller.dto.LoanStateDTO;
import com.ironhack.edgeservice.controller.dto.LoanedBook;
import com.ironhack.edgeservice.controller.dto.LoanedDTO;
import com.ironhack.edgeservice.controller.interfaces.LibraryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LibraryControllerImpl implements LibraryController {

    @Autowired
    private BookClient bookClient;
    @Autowired
    private LoanedBookClient loanedBookClient;


    // ----------------------------------//
    //          BOOK CLIENT              //
    // ----------------------------------//

    @GetMapping("/library/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAllBooks() {
        return bookClient.findAllBooks();
    }

    @GetMapping("/library/books/{ean}")
    @ResponseStatus(HttpStatus.OK)
    public Book findBooksByEan(@PathVariable Long ean) {
        return bookClient.findBooksByEan(ean);
    }

    @PostMapping("/library/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookClient.create(book);
    }

    @DeleteMapping("/library/books/{ean}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByEan(@PathVariable Long ean) { bookClient.deleteByEan(ean); }


    // ----------------------------------//
    //        LOANED BOOK CLIENT         //
    // ----------------------------------//

    // STUDENT USER
    @PostMapping("/library/loanedBooks")
    @ResponseStatus(HttpStatus.CREATED)
    public LoanedBook loaningBook(@RequestBody LoanedDTO loanedDTO) {
        return loanedBookClient.loaningBook(loanedDTO);
    }

    @PatchMapping("/library/loanedBooks/{ean}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnBook(@PathVariable Long ean) {
        loanedBookClient.returnBook(ean);
    }


    // ADMIN USER

    @PostMapping("/library/loanedBooks/{ean}")
    @ResponseStatus(HttpStatus.CREATED)
    public LoanedBook createLoanedBookRegister(@RequestParam Long ean){
        return loanedBookClient.createLoanedBookRegister(ean);
    }

    @GetMapping("/library/loanedBooks")
    @ResponseStatus(HttpStatus.OK)
    public List<LoanedBook> findAllLoanedBooks() {
        return loanedBookClient.findAllLoanedBooks();
    }

    @GetMapping("/library/loanedBooks/{ean}")
    @ResponseStatus(HttpStatus.OK)
    public LoanedBook findByEan(@PathVariable Long ean) {
        return loanedBookClient.findByEan(ean);
    }

    @GetMapping("/library/loanedBooks/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<LoanedBook> findByUserId(@PathVariable Long userId) {
        return loanedBookClient.findByUserId(userId);
    }

    @GetMapping("/library/loanedBooks/available")
    @ResponseStatus(HttpStatus.OK)
    public List<LoanedBook> findByLoanState_Available() {
        return loanedBookClient.findByLoanState_Available();
    }

    @GetMapping("/library/loanedBooks/lost")
    @ResponseStatus(HttpStatus.OK)
    public List<LoanedBook> findByLoanState_Lost() {
        return loanedBookClient.findByLoanState_Lost();
    }

    @GetMapping("/library/loanedBooks/loaned")
    @ResponseStatus(HttpStatus.OK)
    public List<LoanedBook> findByLoanState_Loaned() {
        return loanedBookClient.findByLoanState_Loaned();
    }

    @GetMapping("/library/loanedBooks/overdue")
    @ResponseStatus(HttpStatus.OK)
    public List<LoanedBook> findByLoanState_Overdue() {
        return loanedBookClient.findByLoanState_Overdue();
    }

    @PatchMapping("/library/loanedBooks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus (@PathVariable Long id, @RequestBody LoanStateDTO loanStateDTO) {
        loanedBookClient.updateStatus(id, loanStateDTO);
    }

    @PatchMapping("/library/loanedBooks/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatusLoans() {
        loanedBookClient.updateStatusLoans();
    }
}
