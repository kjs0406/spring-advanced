package com.sparta.currency_user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserToCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer amountInKrw;

    Float amountAfterExchange;

    String status;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    Currency currency;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
