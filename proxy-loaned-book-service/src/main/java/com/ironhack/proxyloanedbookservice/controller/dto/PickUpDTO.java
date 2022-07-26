package com.ironhack.proxyloanedbookservice.controller.dto;

import com.ironhack.proxyloanedbookservice.enums.PickedUp;

public class PickUpDTO {
    private Long loanedBookId;

    public PickUpDTO() {
    }

    public PickUpDTO( Long loanedBookId) {

        this.loanedBookId = loanedBookId;
    }

    public Long getLoanedBookId() {
        return loanedBookId;
    }

    public void setLoanedBookId(Long loanedBookId) {
        this.loanedBookId = loanedBookId;
    }
}
