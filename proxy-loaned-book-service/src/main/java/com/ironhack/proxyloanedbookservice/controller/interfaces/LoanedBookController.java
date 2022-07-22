package com.ironhack.proxyloanedbookservice.controller.interfaces;

import com.ironhack.proxyloanedbookservice.controller.dto.LoanedDTO;
import com.ironhack.proxyloanedbookservice.models.LoanedBook;

public interface LoanedBookController {

    // USER STUDENT
    LoanedBook loaningBook(LoanedDTO loanedDTO);

    void returnBook(Long ean);

}
