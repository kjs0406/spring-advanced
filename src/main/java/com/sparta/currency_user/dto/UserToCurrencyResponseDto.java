package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.entity.UserToCurrency;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class UserToCurrencyResponseDto {
    private Long userId;
    private Long currencyId;
    private Integer amountInKrw;
    private BigDecimal amountAfterExchange;

    public UserToCurrencyResponseDto (UserToCurrency userToCurrency) {
        this.userId = userToCurrency.getId();
        this.currencyId = userToCurrency.getCurrency().getId();
        this.amountInKrw = userToCurrency.getAmountInKrw();
        this.amountAfterExchange = userToCurrency.getAmountAfterExchange();
    }

    public UserToCurrencyResponseDto (Long userId, Long currencyId, Integer amountInKrw, BigDecimal amountAfterExchange) {
        this.userId = userId;
        this.currencyId = currencyId;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
    }
}