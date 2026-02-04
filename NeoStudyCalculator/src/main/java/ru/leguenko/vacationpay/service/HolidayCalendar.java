package ru.leguenko.vacationpay.service;

import java.time.LocalDate;

public interface HolidayCalendar {
    boolean isHoliday(LocalDate date);
}
