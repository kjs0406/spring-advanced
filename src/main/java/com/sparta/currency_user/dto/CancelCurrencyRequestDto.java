package com.sparta.currency_user.dto;

import lombok.Getter;

@Getter
public class CancelCurrencyRequestDto {

    private String status;

    public CancelCurrencyRequestDto(String status){
        this.status = status;
    }

    public CancelCurrencyRequestDto() {
    }
}
