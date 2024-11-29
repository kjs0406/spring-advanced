package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.UserResponseDto;
import com.sparta.currency_user.dto.UserToCurrencyRequestDto;
import com.sparta.currency_user.dto.UserToCurrencyResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.entity.UserToCurrency;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.UserRepository;
import com.sparta.currency_user.repository.UserToCurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserToCurrencyService {

    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;
    private final UserToCurrencyRepository userToCurrencyRepository;
    private final UserService userService;

    @Transactional
    public UserToCurrencyResponseDto saveUserToCurrency(UserToCurrencyRequestDto userToCurrencyRequestDto) {
        User findUId = userService.findUserById(userToCurrencyRequestDto.getUserId());
        Currency findCId = currencyRepository.findById(userToCurrencyRequestDto.getCurrencyId()).orElseThrow(() -> new IllegalArgumentException("통화를 찾을 수 없습니다."));

        BigDecimal amountIntKrw = new BigDecimal(userToCurrencyRequestDto.getAmountInKrw());
        BigDecimal findRate = findCId.getExchangeRate();
        BigDecimal amountAfterExchange =  amountIntKrw.divide(findRate, 2, BigDecimal.ROUND_HALF_UP);

        UserToCurrency userToCurrency = new UserToCurrency(findUId, findCId, userToCurrencyRequestDto.getAmountInKrw(),amountAfterExchange);
        findUId.addUserToCurrency(userToCurrency);

        return new UserToCurrencyResponseDto(userToCurrency);
    }

    public UserToCurrency findCurrencyByUserId(Long id) {

        return userToCurrencyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
    }

    @Transactional
    public UserToCurrencyResponseDto cancelCurrency(Long id, String status) {
        UserToCurrency findId = userToCurrencyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        findId.cancelCurrency(status);

        return new UserToCurrencyResponseDto(findId.getId(), findId.getStatus());
    }
}
