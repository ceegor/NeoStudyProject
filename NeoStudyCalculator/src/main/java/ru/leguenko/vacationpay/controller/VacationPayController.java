package ru.leguenko.vacationpay.controller;


import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.leguenko.vacationpay.service.VacationPayService;
import ru.leguenko.vacationpay.dto.CalculateResponse;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculate")
@RequiredArgsConstructor
@Validated
public class VacationPayController {

    private final VacationPayService service;

    @GetMapping
    public CalculateResponse calculate(@RequestParam("averageSalary") @Positive BigDecimal averageSalary,
                                       @RequestParam("vacationDays") @Positive Integer vacationDays) {
        BigDecimal result = service.calculate(averageSalary, vacationDays);

        return new CalculateResponse(result);
    }
}
