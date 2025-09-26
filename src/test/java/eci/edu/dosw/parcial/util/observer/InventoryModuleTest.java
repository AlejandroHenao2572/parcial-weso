package eci.edu.dosw.parcial.util.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryModuleTest {

    private InventoryModule inventoryModule;
    private PaymentData paymentData;

    @BeforeEach
    void setUp() {
        inventoryModule = new InventoryModule();
        paymentData = new PaymentData(75.25, "paypal", "TXN-789");
    }

    @Test
    void testOnPaymentProcessed() {
        assertDoesNotThrow(() -> {
            inventoryModule.onPaymentProcessed(paymentData);
        });
    }

    @Test
    void testImplementsPaymentObserver() {
        assertInstanceOf(PaymentObserver.class, inventoryModule);
    }

    @Test
    void testOnPaymentProcessedWithHighAmount() {
        PaymentData data = new PaymentData(1000.0, "crypto", "TXN-999");
        assertDoesNotThrow(() -> {
            inventoryModule.onPaymentProcessed(data);
        });
    }
}