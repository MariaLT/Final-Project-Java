package com.ironhack.edgeservice.controller.dto;

import com.ironhack.edgeservice.enums.LoanState;
import com.ironhack.edgeservice.enums.PickedUp;

import java.time.LocalDate;

public class LoanedBook {

    private Long loanedBookId;
    private Long ean;
    private LoanState loanState;
    private LocalDate loanDate;
    private LocalDate returnDate;

    private PickedUp pickedUp;
    private Long userId;

    public LoanedBook() {
    }

    public LoanedBook(Long ean, LoanState loanState, LocalDate loanDate, LocalDate returnDate, PickedUp pickedUp, Long userId) {
        this.ean = ean;
        this.loanState = loanState;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.pickedUp = pickedUp;
        this.userId = userId;
    }

    public Long getLoanedBookId() {
        return loanedBookId;
    }

    public void setLoanedBookId(Long loanedBookId) {
        this.loanedBookId = loanedBookId;
    }

    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public LoanState getLoanState() {
        return loanState;
    }

    public void setLoanState(LoanState loanState) {
        this.loanState = loanState;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public PickedUp getPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(PickedUp pickedUp) {
        this.pickedUp = pickedUp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
