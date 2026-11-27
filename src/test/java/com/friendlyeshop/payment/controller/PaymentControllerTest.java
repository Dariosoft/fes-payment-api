package com.friendlyeshop.payment.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PaymentControllerTest {

    @Test
    void reportsThatTheServiceIsRunning() {
        PaymentController controller = new PaymentController();

        assertEquals(
                "Payments API is up and running. "
                        + "This endpoint is a placeholder until the real payment flow is implemented.",
                controller.payments());
    }
}
