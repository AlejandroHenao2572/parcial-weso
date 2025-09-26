package eci.edu.dosw.parcial.util.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BillingModuleTest {

    private BillingModule billingModule;
    private PaymentData paymentData;

    @BeforeEach
    void setUp() {
        billingModule = new BillingModule();
        paymentData = new PaymentData(100.0, "creditcard", "TXN-123");
    }

    @Test
    void testOnPaymentProcessed() {
        assertDoesNotThrow(() -> {
            billingModule.onPaymentProcessed(paymentData);
        });
    }

    @Test
    void testImplementsPaymentObserver() {
        assertInstanceOf(PaymentObserver.class, billingModule);
    }

    @Test
    void testOnPaymentProcessedWithDifferentData() {
        PaymentData data = new PaymentData(250.50, "paypal", "ABC-123");
        assertDoesNotThrow(() -> {
            billingModule.onPaymentProcessed(data);
        });
    }
}