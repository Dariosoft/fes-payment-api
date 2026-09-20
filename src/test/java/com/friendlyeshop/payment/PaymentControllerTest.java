package com.friendlyeshop.payment;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class PaymentControllerTest {
    @Test
    void identifiesService() {
        assertThat(new PaymentController().payments()).containsEntry("service", "payment-api");
    }
}
