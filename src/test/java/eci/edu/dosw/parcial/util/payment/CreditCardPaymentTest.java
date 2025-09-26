package eci.edu.dosw.parcial.util.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreditCardPaymentTest {

    private CreditCardPayment creditCardPayment;

    @BeforeEach
    void setUp() {
        creditCardPayment = new CreditCardPayment();
    }

    @Test
    void testProcessPaymentPositiveAmount() {
        double amount = 100.50;
        
        boolean result = creditCardPayment.processPayment(amount);

        assertTrue(result);
    }

    @Test
    void testProcessPaymentZeroAmount() {

        double amount = 0.0;
    
        boolean result = creditCardPayment.processPayment(amount);
        
    
        assertTrue(result);
    }

    @Test
    void testProcessPaymentNegativeAmount() {
        
        double amount = -50.0;
        
        boolean result = creditCardPayment.processPayment(amount);
        
        assertTrue(result);
    }
}