package com.ironhack.edgeservice.controller.dto;

import com.ironhack.edgeservice.enums.LOAN_STATE;

public class LoanStateDTO {

    private LOAN_STATE LOANSTATE;

    public LoanStateDTO() {
    }

    public LoanStateDTO(LOAN_STATE LOANSTATE) {
        this.LOANSTATE = LOANSTATE;
    }

    public LOAN_STATE getLoanState() {
        return LOANSTATE;
    }

    public void setLoanState(LOAN_STATE LOANSTATE) {
        this.LOANSTATE = LOANSTATE;
    }
}
