package com.friendlyeshop.payment;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @GetMapping
    public Map<String, Object> payments() {
        return Map.of("service", "payment-api", "status", "ready", "payments", List.of());
    }
}
