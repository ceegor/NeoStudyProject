package ru.leguenko.vacationpay.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CalculateQuery {

    @NotNull
    @Positive
    private BigDecimal averageSalary;

    @Positive
    private Integer vacationDays;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    @AssertTrue(message = "Specify either vacationDays OR both startDate and endDate")
    public boolean isValidCombination() {
        boolean daysProvided = vacationDays != null;
        boolean datesProvided = startDate != null && endDate != null;

        if (daysProvided == datesProvided) {
            return false;
        }

        if (datesProvided) {
            return !endDate.isBefore(startDate);
        }

        return true;
    }
}
