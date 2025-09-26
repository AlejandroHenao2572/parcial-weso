package eci.edu.dosw.parcial.util.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificationModuleTest {

    private NotificationModule notificationModule;
    private PaymentData paymentData;

    @BeforeEach
    void setUp() {
        notificationModule = new NotificationModule();
        paymentData = new PaymentData(150.0, "crypto", "TXN-333");
    }

    @Test
    void testOnPaymentProcessed() {
        assertDoesNotThrow(() -> {
            notificationModule.onPaymentProcessed(paymentData);
        });
    }

    @Test
    void testImplementsPaymentObserver() {
        assertInstanceOf(PaymentObserver.class, notificationModule);
    }

    @Test
    void testOnPaymentProcessedWithSmallAmount() {
        PaymentData data = new PaymentData(5.99, "creditcard", "TXN-001");
        assertDoesNotThrow(() -> {
            notificationModule.onPaymentProcessed(data);
        });
    }
}