package ru.leguenko.vacationpay.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VacationPayControllerValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void missingAverageSalary_returns400() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("vacationDays", "10"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(jsonPath("$.code").value("VALIDATION_ERROR"));
    }
}
