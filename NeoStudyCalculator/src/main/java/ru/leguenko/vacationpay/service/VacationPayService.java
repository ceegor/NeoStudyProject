package ru.leguenko.vacationpay.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class VacationPayService {

    private static final BigDecimal AVERAGE_DAYS = BigDecimal.valueOf(29.3);

    public BigDecimal calculate(BigDecimal salary, int days) {
        BigDecimal daily = salary.divide(AVERAGE_DAYS, 2, RoundingMode.HALF_UP);

        return daily
                .multiply(BigDecimal.valueOf(days))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
