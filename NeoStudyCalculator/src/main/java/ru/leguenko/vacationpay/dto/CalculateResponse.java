package ru.leguenko.vacationpay.dto;

import java.math.BigDecimal;

public class CalculateResponse {

    private final BigDecimal amount;
    private final int payableDays;

    public CalculateResponse(BigDecimal amount, int payableDays) {
        this.amount = amount;
        this.payableDays = payableDays;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPayableDays() {
        return payableDays;
    }
}
