package com.ironhack.edgeservice.controller.dto;

import com.ironhack.edgeservice.enums.PickedUp;

public class PickUpDTO {

    private Long ean;

    public PickUpDTO() {
    }

    public PickUpDTO(Long ean) {
        this.ean = ean;
    }

    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }
}
