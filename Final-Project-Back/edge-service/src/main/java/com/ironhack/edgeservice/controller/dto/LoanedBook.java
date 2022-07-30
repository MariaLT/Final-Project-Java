package com.ironhack.edgeservice.controller.dto;

import com.ironhack.edgeservice.enums.LOAN_STATE;
import com.ironhack.edgeservice.enums.PICKED_UP;

import java.time.LocalDate;

public class LoanedBook {

    private Long ean;
    private LOAN_STATE LOANSTATE;
    private LocalDate loanDate;
    private LocalDate returnDate;

    private PICKED_UP PICKEDUP;
    private Long userId;

    public LoanedBook() {
    }

    public LoanedBook(Long ean, LOAN_STATE LOANSTATE, LocalDate loanDate, LocalDate returnDate, PICKED_UP PICKEDUP, Long userId) {
        this.ean = ean;
        this.LOANSTATE = LOANSTATE;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.PICKEDUP = PICKEDUP;
        this.userId = userId;
    }


    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public LOAN_STATE getLoanState() {
        return LOANSTATE;
    }

    public void setLoanState(LOAN_STATE LOANSTATE) {
        this.LOANSTATE = LOANSTATE;
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

    public PICKED_UP getPickedUp() {
        return PICKEDUP;
    }

    public void setPickedUp(PICKED_UP PICKEDUP) {
        this.PICKEDUP = PICKEDUP;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
