package com.ironhack.edgeservice.controller.dto;

import com.ironhack.edgeservice.enums.LoanState;

public class LoanStateDTO {

    private LoanState loanState;

    public LoanStateDTO() {
    }

    public LoanStateDTO(LoanState loanState) {
        this.loanState = loanState;
    }

    public LoanState getLoanState() {
        return loanState;
    }

    public void setLoanState(LoanState loanState) {
        this.loanState = loanState;
    }
}
