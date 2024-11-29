package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserToCurrency extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer amountInKrw;

    BigDecimal amountAfterExchange;

    String status;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    Currency currency;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    public UserToCurrency(User user, Currency currency, Integer amountInKrw ,BigDecimal amountAfterExchange) {
        this.user = user;
        this.currency = currency;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
    }

    public void cancelCurrency(String status) {
        this.status = "cancelled";
        }
}
