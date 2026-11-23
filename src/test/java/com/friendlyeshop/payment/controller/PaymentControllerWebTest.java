package com.friendlyeshop.payment.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PaymentController.class)
class PaymentControllerWebTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void servesTheControllerUnderThePaymentsPrefix() throws Exception {
        mockMvc.perform(get("/payments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.service").value("payment-api"));
    }

    @Test
    void doesNotServeTheControllerWithoutThePrefix() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isNotFound());
    }
}
