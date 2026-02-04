package ru.leguenko.vacationpay.service;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.Set;

@Component
public class RussianHolidayCalendar implements HolidayCalendar {
    private static final Set<MonthDay> HOLIDAYS = Set.of(
            MonthDay.of(Month.FEBRUARY, 23),
            MonthDay.of(Month.MARCH, 8),
            MonthDay.of(Month.MAY, 1),
            MonthDay.of(Month.MAY, 9),
            MonthDay.of(Month.JUNE, 12),
            MonthDay.of(Month.NOVEMBER, 4)
    );

    @Override
    public boolean isHoliday(LocalDate date) {
        if (date.getMonth() == Month.JANUARY && date.getDayOfMonth() <= 8) {
            return true;
        }
        return HOLIDAYS.contains(MonthDay.from(date));
    }
}
