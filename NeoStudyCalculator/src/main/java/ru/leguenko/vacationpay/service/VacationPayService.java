package ru.leguenko.vacationpay.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.leguenko.vacationpay.dto.CalculateResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class VacationPayService {

    private static final BigDecimal AVERAGE_DAYS = BigDecimal.valueOf(29.3);

    private final BusinessDayCounter businessDayCounter;

    public VacationPayService(BusinessDayCounter businessDayCounter) {
        this.businessDayCounter = businessDayCounter;
    }

    public CalculationResult calculateByDays(BigDecimal salary, int days) {
        BigDecimal amount = calculateAmount(salary, days);
        return new CalculationResult(amount, days);
    }

    public CalculationResult calculateByDates(BigDecimal salary, LocalDate startDate, LocalDate endDate) {
        int payableDays = businessDayCounter.countPayableDays(startDate, endDate);
        BigDecimal amount = calculateAmount(salary, payableDays);
        return new CalculationResult(amount, payableDays);
    }

    private BigDecimal calculateAmount(BigDecimal salary, int days) {
        BigDecimal daily = salary.divide(AVERAGE_DAYS, 10, RoundingMode.HALF_UP);
        return daily.multiply(BigDecimal.valueOf(days)).setScale(2, RoundingMode.HALF_UP);
    }

    @Getter
    public static class CalculationResult {
        private final BigDecimal amount;
        private final int payableDays;

        public CalculationResult(BigDecimal amount, int payableDays) {
            this.amount = amount;
            this.payableDays = payableDays;
        }

    }
}
