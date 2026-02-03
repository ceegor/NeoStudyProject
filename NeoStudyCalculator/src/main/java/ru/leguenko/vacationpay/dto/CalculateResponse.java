package ru.leguenko.vacationpay.dto;

import java.math.BigDecimal;

public class CalculateResponse {

    private BigDecimal amount;

    public CalculateResponse(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
