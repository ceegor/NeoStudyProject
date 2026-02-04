package ru.leguenko.vacationpay.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class BusinessDayCounter {

    private final HolidayCalendar holidayCalendar;

    public BusinessDayCounter(HolidayCalendar holidayCalendar) {
        this.holidayCalendar = holidayCalendar;
    }

    public int countPayableDays(LocalDate start, LocalDate end) {
        int count = 0;
        LocalDate date = start;
        while (!date.isAfter(end)) {
            if (isPayableDay(date)) {
                count++;
            }
            date = date.plusDays(1);
        }
        return count;
    }

    private boolean isPayableDay(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        boolean weekend = (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY);
        if (weekend) return false;
        return !holidayCalendar.isHoliday(date);
    }
}
