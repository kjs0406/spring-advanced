package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.*;
import com.sparta.currency_user.service.UserService;
import com.sparta.currency_user.service.UserToCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toCurrency")
@RequiredArgsConstructor
public class UserToCurrencyController {

    private final UserToCurrencyService userToCurrencyService;

    @PostMapping
    public ResponseEntity<UserToCurrencyResponseDto> createUserToCurrency(@RequestBody UserToCurrencyRequestDto userToCurrencyRequestDto) {
        return ResponseEntity.ok().body(userToCurrencyService.saveUserToCurrency(userToCurrencyRequestDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserToCurrencyResponseDto> findCurrencyByUserId(@PathVariable Long id) {
        return ResponseEntity.ok().body(userToCurrencyService.findCurrencyByUserId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserToCurrencyResponseDto> cancleUserToCurrency(
            @PathVariable(value = "id") Long id,
            @RequestBody CancelCurrencyRequestDto requestDto) {

        UserToCurrencyResponseDto userToCurrencyResponseDto = userToCurrencyService.CancelCurrencyRequestDto(id, requestDto.getStatus());

        return new ResponseEntity<>(userToCurrencyResponseDto, HttpStatus.OK);
    }
}
