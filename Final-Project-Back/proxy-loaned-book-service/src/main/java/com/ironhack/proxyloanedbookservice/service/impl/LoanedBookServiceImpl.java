package com.ironhack.proxyloanedbookservice.service.impl;

import com.ironhack.proxyloanedbookservice.controller.dto.LoanedDTO;
import com.ironhack.proxyloanedbookservice.enums.LOAN_STATE;
import com.ironhack.proxyloanedbookservice.enums.PICKED_UP;
import com.ironhack.proxyloanedbookservice.models.LoanedBook;
import com.ironhack.proxyloanedbookservice.repository.LoanedBookRepository;
import com.ironhack.proxyloanedbookservice.service.interfaces.LoanedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanedBookServiceImpl implements LoanedBookService {

    @Autowired
    private LoanedBookRepository loanedBookRepository;

    @Override
    public LoanedBook loaningBook(LoanedDTO loanedDTO) {
        LoanedBook loanedBook = loanedBookRepository.findByEan(loanedDTO.getEan()).get();
        if (loanedBook.getLoanState().equals(LOAN_STATE.LOANED)
                || loanedBook.getLoanState().equals(LOAN_STATE.OVERDUE)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book already loaned");
        } else if (loanedBook.getLoanState().equals(LOAN_STATE.LOST)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book lost");
        }

        loanedBook.setEan(loanedDTO.getEan());
        loanedBook.setLoanState(LOAN_STATE.LOANED);
        loanedBook.setLoanDate(LocalDate.now());
        loanedBook.setReturnDate(LocalDate.now().plusDays(21));
        loanedBook.setPickedUp(PICKED_UP.NO);
        loanedBook.setUserId(loanedDTO.getUserId());
        return loanedBook;
    }

    @Override
    public LoanedBook returnBook(Long ean) {
        LoanedBook loanedBook = loanedBookRepository.findByEan(ean)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book does not exist"));

/*        if (loanedBook.getLoanState() != (LoanState.LOANED) || loanedBook.getLoanState() != (LoanState.OVERDUE)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book does not loaned");
        }*/

        loanedBook.setLoanState(LOAN_STATE.AVAILABLE);
        loanedBook.setUserId(null);
        loanedBook.setLoanDate(null);
        loanedBook.setReturnDate(null);
        loanedBook.setPickedUp(null);

        return loanedBook;

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
    public LoanedBook findByEan(Long ean) {
        LoanedBook loanedBook = loanedBookRepository.findByEan(ean)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book does not exist"));

        return loanedBook;
    }

    @Override
    public List<LoanedBook> findByUserId(Long userId) {
        List<LoanedBook> loanedBook = loanedBookRepository.findAllByUserId(userId);
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
    public LoanedBook updateStatus(Long ean, LOAN_STATE loanState) {
        LoanedBook loanedBook = loanedBookRepository.findByEan(ean)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        loanedBook.setLoanState(loanState);
        return loanedBook;
    }

    @Override
    public List<LoanedBook> updateStatusLoans() {
        List<LoanedBook> loanedBooks = loanedBookRepository.findAll();
        for (LoanedBook loanedBook : loanedBooks) {
            if (loanedBook.getReturnDate() != null) {
                if (loanedBook.getReturnDate().isBefore(LocalDate.now())) {
                    loanedBook.setLoanState(LOAN_STATE.OVERDUE);

                }
            }

        }
        return loanedBooks;
    }

    public LoanedBook createLoanedBook(Long ean) {
        Optional<LoanedBook> loanedBook = loanedBookRepository.findByEan(ean);
        if (loanedBook.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Already created");
        }
        LoanedBook loanedBookBack = new LoanedBook();
        loanedBookBack.setEan(ean);
        loanedBookBack.setLoanState(LOAN_STATE.AVAILABLE);
        loanedBookBack.setLoanDate(null);
        loanedBookBack.setReturnDate(null);
        loanedBookBack.setUserId(null);

        return loanedBookBack;

    }

    public LoanedBook updatePickUp(Long ean) {
        LoanedBook loanedBook = loanedBookRepository.findByEan(ean)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Register " +
                                "Loaned Book not found"));
        if (loanedBook.getPickedUp() == PICKED_UP.YES) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Already picked up");
        }
        loanedBook.setPickedUp(PICKED_UP.YES);
        return loanedBook;
    }
}

