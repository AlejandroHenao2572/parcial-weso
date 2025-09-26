package eci.edu.dosw.parcial.util.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EciPaymentsTest {

    private EciPayments eciPayments;
    private BillingModule billingModule;
    private InventoryModule inventoryModule;
    private NotificationModule notificationModule;

    @BeforeEach
    void setUp() {
        eciPayments = new EciPayments();
        billingModule = new BillingModule();
        inventoryModule = new InventoryModule();
        notificationModule = new NotificationModule();
    }

    @Test
    void testAddObserver() {
        assertDoesNotThrow(() -> {
            eciPayments.addObserver(billingModule);
        });
    }

    @Test
    void testRemoveObserver() {
        eciPayments.addObserver(billingModule);
        assertDoesNotThrow(() -> {
            eciPayments.removeObserver(billingModule);
        });
    }

    @Test
    void testProcessPaymentCreditCard() {
        eciPayments.addObserver(billingModule);
        boolean result = eciPayments.processPayment(100.0, "creditcard");
        assertTrue(result);
    }

    @Test
    void testProcessPaymentPayPal() {
        eciPayments.addObserver(inventoryModule);
        boolean result = eciPayments.processPayment(75.50, "paypal");
        assertTrue(result);
    }

    @Test
    void testProcessPaymentCrypto() {
        eciPayments.addObserver(notificationModule);
        boolean result = eciPayments.processPayment(200.25, "crypto");
        assertTrue(result);
    }

    @Test
    void testProcessPaymentWithMultipleObservers() {
        eciPayments.addObserver(billingModule);
        eciPayments.addObserver(inventoryModule);
        eciPayments.addObserver(notificationModule);
        boolean result = eciPayments.processPayment(150.0, "creditcard");
        assertTrue(result);
    }

    @Test
    void testProcessPaymentUnsupportedType() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            eciPayments.processPayment(100.0, "invalido");
        });
        
        assertEquals("Tipo de pago no soportado", exception.getMessage());
    }

    @Test
    void testProcessPaymentWithZeroAmount() {
        boolean result = eciPayments.processPayment(0.0, "creditcard");
        assertTrue(result);
    }
}