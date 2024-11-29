package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.UserToCurrency;
import lombok.Getter;
import com.sparta.currency_user.entity.User;

@Getter
public class UserToCurrencyRequestDto {
    private Long userId;
    private Long currencyId;
    private Integer amountInKrw;


}
