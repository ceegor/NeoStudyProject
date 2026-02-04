package ru.leguenko.vacationpay.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacationPayServiceTest {
    @Test
    void calculateByDays_returnsAmountAndDays() {
        HolidayCalendar calendar = date -> false;
        BusinessDayCounter counter = new BusinessDayCounter(calendar);
        VacationPayService service = new VacationPayService(counter);

        VacationPayService.CalculationResult r = service.calculateByDays(new BigDecimal("60000"), 10);

        assertEquals(10, r.getPayableDays());
        assertEquals(new BigDecimal("20477.82"), r.getAmount());
    }

    @Test
    void calculateByDates_usesPayableDays() {
        HolidayCalendar calendar = date -> false;
        BusinessDayCounter counter = new BusinessDayCounter(calendar);
        VacationPayService service = new VacationPayService(counter);

        VacationPayService.CalculationResult r = service.calculateByDates(new BigDecimal("60000"),
                        LocalDate.of(2026, 5, 4),
                        LocalDate.of(2026, 5, 8));

        assertEquals(5, r.getPayableDays());
        assertEquals(new BigDecimal("10238.91"), r.getAmount());
    }
}
