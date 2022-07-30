package com.ironhack.proxyloanedbookservice.controller.dto;

public class LoanedDTO {
    private Long ean;
    private Long userId;

    public LoanedDTO() {
    }

    public LoanedDTO(Long ean, Long userId) {
        this.ean = ean;
        this.userId = userId;
    }

    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
