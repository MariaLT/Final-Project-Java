package com.ironhack.proxyloanedbookservice.models;

import com.ironhack.proxyloanedbookservice.enums.LoanState;
import com.ironhack.proxyloanedbookservice.enums.PickedUp;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "info_loaned_book")
public class LoanedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanedBookId;
    @NotNull
    private Long ean;
    @Enumerated(EnumType.STRING)
    private LoanState loanState;
    private LocalDate loanDate;
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    private PickedUp pickedUp;
    private Long userId;


    public LoanedBook() {
    }

    public LoanedBook(Long ean, LoanState loanState, LocalDate loanDate, LocalDate returnDate,
                      PickedUp pickedUp, Long userId) {
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

    public Long getLoanedBookId() {
        return loanedBookId;
    }

    public void setLoanedBookId(Long loanedBookId) {
        this.loanedBookId = loanedBookId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PickedUp getPickUp() {
        return pickedUp;
    }

    public void setPickUp(PickedUp pickedUp) {
        this.pickedUp = pickedUp;
    }
}

