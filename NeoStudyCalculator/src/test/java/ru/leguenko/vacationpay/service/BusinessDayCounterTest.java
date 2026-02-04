package ru.leguenko.vacationpay.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BusinessDayCounterTest {
    @Test
    void countsPayableDays_excludesWeekendsAndHolidays() {
        HolidayCalendar calendar = date -> date.equals(LocalDate.of(2026, 5, 1));
        BusinessDayCounter businessDayCounter = new BusinessDayCounter(calendar);

        int days = businessDayCounter.countPayableDays(LocalDate.of(2026, 5, 1), LocalDate.of(2026, 5, 3));
        assertEquals(0, days);
    }
}
