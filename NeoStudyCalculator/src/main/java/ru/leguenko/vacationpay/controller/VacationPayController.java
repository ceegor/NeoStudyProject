package ru.leguenko.vacationpay.controller;


import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.leguenko.vacationpay.dto.CalculateQuery;
import ru.leguenko.vacationpay.service.VacationPayService;
import ru.leguenko.vacationpay.dto.CalculateResponse;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculate")
@Validated
public class VacationPayController {

    private final VacationPayService service;

    public VacationPayController(VacationPayService service) {
        this.service = service;
    }

    @GetMapping
    public CalculateResponse calculate(@Valid @ModelAttribute CalculateQuery query) {

        VacationPayService.CalculationResult result;

        if (query.getVacationDays() != null) {
            result = service.calculateByDays(query.getAverageSalary(), query.getVacationDays());
        } else {
            result = service.calculateByDates(query.getAverageSalary(), query.getStartDate(), query.getEndDate());
        }

        return new CalculateResponse(result.getAmount(), result.getPayableDays());
    }
}
