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
import java.util.List;

@Service
public class LoanedBookServiceImpl implements LoanedBookService {

    @Autowired
    private LoanedBookRepository loanedBookRepository;

    @Override
    public LoanedBook loaningBook(LoanedDTO loanedDTO) {
        LoanedBook loanedBook = loanedBookRepository.findByEan(loanedDTO.getEan())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        if (loanedBook.getLoanState().equals(LoanState.LOANED)
                || loanedBook.getLoanState().equals(LoanState.OVERDUE)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book already loaned");
        } else if (loanedBook.getLoanState().equals(LoanState.LOST)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book lost");
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
        LoanedBook loanedBook = loanedBookRepository.findByEan(ean)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book does not exist"));
        if (loanedBook.getLoanState() != (LoanState.LOANED)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book does not loaned");
        }
        loanedBook.setLoanState(LoanState.AVAILABLE);

    }

    @Override
    public List<LoanedBook> findAll() {
        List<LoanedBook> loanedBook = loanedBookRepository.findAll();
        if (loanedBook == null || loanedBook.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No loaned books found");
        }
        return loanedBook;
    }

    @Override
    public List<LoanedBook> findByEan(Long ean) {
        List<LoanedBook> loanedBook = loanedBookRepository.findListByEan(ean);
        if (loanedBook == null || loanedBook.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No loaned books found");
        }
        return loanedBook;
    }

    @Override
    public List<LoanedBook> findByUserId(Long userId) {
        List<LoanedBook> loanedBook = loanedBookRepository.findByUserId(userId);
        if (loanedBook == null || loanedBook.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No loaned books found" +
                    "for this user");
        }
        return loanedBook;
    }


    @Override
    public List<LoanedBook> findByLoanState_Available() {
        List<LoanedBook> loanedBook = loanedBookRepository.findByLoanState_Available();
        if (loanedBook == null || loanedBook.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No available books found");
        }
        return loanedBook;
    }

    @Override
    public List<LoanedBook> findByLoanState_Lost() {
        List<LoanedBook> loanedBook = loanedBookRepository.findByLoanState_Lost();
        if (loanedBook == null || loanedBook.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No lost books found");
        }
        return loanedBook;
    }

    @Override
    public List<LoanedBook> findByLoanState_Loaned() {
        List<LoanedBook> loanedBook = loanedBookRepository.findByLoanState_Loaned();
        if (loanedBook == null || loanedBook.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No loaned books found");
        }
        return loanedBook;
    }

    @Override
    public List<LoanedBook> findByLoanState_Overdue() {
        List<LoanedBook> loanedBook = loanedBookRepository.findByLoanState_Overdue();
        if (loanedBook == null || loanedBook.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No overdue books found");
        }
        return loanedBook;
    }

    @Override
    public void updateStatus(Long id, LoanState loanState) {
        LoanedBook loanedBook = loanedBookRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        loanedBook.setLoanState(loanState);
    }

    @Override
    public void updateStatusLoans() {
        List<LoanedBook> loanedBooks = loanedBookRepository.findAll();
        for (LoanedBook loanedBook : loanedBooks) {
            if (loanedBook.getLoanDate().isBefore(LocalDate.now())) {
                loanedBook.setLoanState(LoanState.OVERDUE);
            }
        }
    }
}

