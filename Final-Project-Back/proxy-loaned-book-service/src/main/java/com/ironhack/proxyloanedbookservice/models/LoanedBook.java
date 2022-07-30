package com.ironhack.proxyloanedbookservice.models;

import com.ironhack.proxyloanedbookservice.enums.LOAN_STATE;
import com.ironhack.proxyloanedbookservice.enums.PICKED_UP;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "info_loaned_book")
public class LoanedBook {

    @Id
    @NotNull
    private Long ean;

    @Enumerated(EnumType.STRING)
    private LOAN_STATE loanState;
    private LocalDate loanDate;
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    private PICKED_UP pickedUp;
    private Long userId;


    public LoanedBook() {
    }

    public LoanedBook(Long ean, LOAN_STATE loanState, LocalDate loanDate,
                      LocalDate returnDate, PICKED_UP pickedUp, Long userId) {
        this.ean = ean;
        this.loanState = loanState;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.pickedUp = pickedUp;
        this.userId = userId;
    }

    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public LOAN_STATE getLoanState() {
        return loanState;
    }

    public void setLoanState(LOAN_STATE loanState) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PICKED_UP getPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(PICKED_UP pickedUp) {
        this.pickedUp = pickedUp;
    }
}

