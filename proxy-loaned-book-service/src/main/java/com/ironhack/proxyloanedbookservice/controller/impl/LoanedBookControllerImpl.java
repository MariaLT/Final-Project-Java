package com.ironhack.proxyloanedbookservice.controller.impl;

import com.ironhack.proxyloanedbookservice.controller.dto.LoanedDTO;
import com.ironhack.proxyloanedbookservice.controller.interfaces.LoanedBookController;
import com.ironhack.proxyloanedbookservice.models.LoanedBook;
import com.ironhack.proxyloanedbookservice.repository.LoanedBookRepository;
import com.ironhack.proxyloanedbookservice.service.interfaces.LoanedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoanedBookControllerImpl implements LoanedBookController {
    @Autowired
    private LoanedBookRepository loanedBookRepository;
    @Autowired
    private LoanedBookService loanedBookService;

    @PostMapping("/loanedBooks")
    @ResponseStatus(HttpStatus.CREATED)
    public LoanedBook loaningBook(@RequestBody LoanedDTO loanedDTO) {
        return loanedBookRepository.save(loanedBookService.loaningBook(loanedDTO));
    }

    @PatchMapping("/loanedBooks/{ean}")
    @ResponseStatus(HttpStatus.OK)
    public void returnBook(@PathVariable Long ean) {


    }
}
