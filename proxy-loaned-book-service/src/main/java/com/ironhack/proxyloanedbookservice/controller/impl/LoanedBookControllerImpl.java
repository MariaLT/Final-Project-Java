package com.ironhack.proxyloanedbookservice.controller.impl;

import com.ironhack.proxyloanedbookservice.controller.dto.LoanedDTO;
import com.ironhack.proxyloanedbookservice.controller.dto.LoanStateDTO;
import com.ironhack.proxyloanedbookservice.controller.dto.PickUpDTO;
import com.ironhack.proxyloanedbookservice.controller.interfaces.LoanedBookController;
import com.ironhack.proxyloanedbookservice.models.LoanedBook;
import com.ironhack.proxyloanedbookservice.repository.LoanedBookRepository;
import com.ironhack.proxyloanedbookservice.service.interfaces.LoanedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoanedBookControllerImpl implements LoanedBookController {
    @Autowired
    private LoanedBookRepository loanedBookRepository;
    @Autowired
    private LoanedBookService loanedBookService;

    //    USER STUDENT
    @PostMapping("/loanedBooks")
    @ResponseStatus(HttpStatus.CREATED)
    public LoanedBook loaningBook(@RequestBody LoanedDTO loanedDTO) {
        return loanedBookRepository.save(loanedBookService.loaningBook(loanedDTO));
    }

    @GetMapping("/loanedBooks/return/{ean}")
    @ResponseStatus(HttpStatus.OK)
    public LoanedBook returnBook(@PathVariable Long ean) {
        return loanedBookRepository.save(loanedBookService.returnBook(ean));
    }

    //    USER ADMIN

    @PostMapping("/loanedBooks/{ean}")
    @ResponseStatus(HttpStatus.CREATED)
    public LoanedBook createLoanedBookRegister(@RequestParam Long ean) {
        return loanedBookRepository.save(loanedBookService.createLoanedBook(ean));
    }
    @GetMapping("/loanedBooks")
    @ResponseStatus(HttpStatus.OK)
    public List<LoanedBook> findAllLoanedBooks() {
        return loanedBookService.findAll();
    }

    @GetMapping("/loanedBooks/{ean}")
    @ResponseStatus(HttpStatus.OK)
    public LoanedBook findByEan(@PathVariable Long ean) {
        return loanedBookService.findByEan(ean);
    }

    // Loaned book by user
    @GetMapping("/loanedBooks/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<LoanedBook> findByUserId(@PathVariable Long userId) {
        return loanedBookService.findByUserId(userId);
    }

    @GetMapping("/loanedBooks/available")
    @ResponseStatus(HttpStatus.OK)
    public List<LoanedBook> findByLoanState_Available() {
        return loanedBookService.findByLoanState_Available();
    }

    @GetMapping("/loanedBooks/lost")
    @ResponseStatus(HttpStatus.OK)
    public List<LoanedBook> findByLoanState_Lost() {
        return loanedBookService.findByLoanState_Lost();
    }

    @GetMapping("/loanedBooks/loaned")
    @ResponseStatus(HttpStatus.OK)
    public List<LoanedBook> findByLoanState_Loaned() {
        return loanedBookService.findByLoanState_Loaned();
    }

    @GetMapping("/loanedBooks/overdue")
    @ResponseStatus(HttpStatus.OK)
    public List<LoanedBook> findByLoanState_Overdue() {
        return loanedBookService.findByLoanState_Overdue();
    }

    @PatchMapping("/loanedBooks/{ean}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public LoanedBook updateStatus(@PathVariable Long ean, @RequestBody LoanStateDTO loanStateDTO) {

        return loanedBookRepository.save(loanedBookService.updateStatus(ean, loanStateDTO.getLoanState()));
    }

    @GetMapping("/loanedBooks/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<LoanedBook> updateStatusLoans() {
        return loanedBookRepository.saveAll(loanedBookService.updateStatusLoans());


    }

    @PutMapping("/loanedBooks/pickUp/{ean}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public LoanedBook updatePickUp(@PathVariable Long ean, @RequestBody PickUpDTO pickUpDTO) {
        return loanedBookRepository.save(loanedBookService.updatePickUp(pickUpDTO.getEan()));
    }

    }

