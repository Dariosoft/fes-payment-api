package com.friendlyeshop.payment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    /** Placeholder so /payments keeps responding until the real payment flow lands. Delete when it does. */
    @GetMapping
    public String payments() {
        return "Payments API is up and running. This endpoint is a placeholder until the real payment flow is implemented.";
    }
}
