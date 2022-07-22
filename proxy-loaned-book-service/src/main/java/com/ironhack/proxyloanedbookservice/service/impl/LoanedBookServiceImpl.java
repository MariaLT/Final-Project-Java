package com.ironhack.proxyloanedbookservice.service.impl;

import com.ironhack.proxyloanedbookservice.controller.dto.LoanedDTO;
import com.ironhack.proxyloanedbookservice.enums.LoanState;
import com.ironhack.proxyloanedbookservice.models.LoanedBook;
import com.ironhack.proxyloanedbookservice.repository.LoanedBookRepository;
import com.ironhack.proxyloanedbookservice.service.interfaces.LoanedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class LoanedBookServiceImpl implements LoanedBookService {

    @Autowired
    private LoanedBookRepository loanedBookRepository;

    @Override
    public LoanedBook loaningBook(LoanedDTO loanedDTO) {
        LoanedBook loanedBook = loanedBookRepository.findById(loanedDTO.getEan())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        if (loanedBook.getLoanState().equals(LoanState.LOANED)
                || loanedBook.getLoanState().equals(LoanState.RETURNED)
                || loanedBook.getLoanState().equals(LoanState.OVERDUE)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book already loaned");
        }
        loanedBook.setEan(loanedDTO.getEan());
        loanedBook.setLoanState(LoanState.LOANED);
        loanedBook.setLoanDate(LocalDate.now());
        loanedBook.setReturnDate(LocalDate.now().plusDays(21));
        loanedBook.setUserId(loanedDTO.getUserId());
        return loanedBook;
    }

    @Override
    public void returnBook(Long ean) {
        LoanedBook loanedBook = loanedBookRepository.findById(ean)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

    }

}
