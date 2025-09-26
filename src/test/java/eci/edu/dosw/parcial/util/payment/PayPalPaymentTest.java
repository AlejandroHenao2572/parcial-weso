package eci.edu.dosw.parcial.util.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PayPalPaymentTest {

    private PayPalPayment payPalPayment;

    @BeforeEach
    void setUp() {
        payPalPayment = new PayPalPayment();
    }

    @Test
    void testProcessPaymentPositiveAmount() {
        // Given
        double amount = 75.25;
        
        // When
        boolean result = payPalPayment.processPayment(amount);
        
        // Then
        assertTrue(result);
    }

    @Test
    void testProcessPaymentZeroAmount() {
        // Given
        double amount = 0.0;
        
        // When
        boolean result = payPalPayment.processPayment(amount);
        
        // Then
        assertTrue(result);
    }

    @Test
    void testProcessPaymentLargeAmount() {
        // Given
        double amount = 999999.99;
        
        // When
        boolean result = payPalPayment.processPayment(amount);
        
        // Then
        assertTrue(result);
    }
}