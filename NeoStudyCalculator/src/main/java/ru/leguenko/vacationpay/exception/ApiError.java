package ru.leguenko.vacationpay.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class ApiError {
    private final String code;
    private final String message;
    private final List<FieldViolation> violations;

    public ApiError(String code, String message, List<FieldViolation> violations) {
        this.code = code;
        this.message = message;
        this.violations = violations;
    }

    @Getter
    public static class FieldViolation {
        private final String field;
        private final String message;

        public FieldViolation(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }
}
