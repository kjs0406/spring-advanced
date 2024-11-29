package com.sparta.currency_user.repository;

import com.sparta.currency_user.entity.UserToCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface UserToCurrencyRepository extends JpaRepository<UserToCurrency, Long> {
    default UserToCurrency findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }
}
