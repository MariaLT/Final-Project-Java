package com.ironhack.proxyloanedbookservice.service.interfaces;

import com.ironhack.proxyloanedbookservice.controller.dto.LoanedDTO;
import com.ironhack.proxyloanedbookservice.models.LoanedBook;

public interface LoanedBookService {

    LoanedBook loaningBook(LoanedDTO loanedDTO);

    void returnBook(Long ean);

}
