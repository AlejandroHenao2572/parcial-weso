package eci.edu.dosw.parcial.util.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CryptoPaymentTest {

    private CryptoPayment cryptoPayment;

    @BeforeEach
    void setUp() {
        cryptoPayment = new CryptoPayment();
    }

    @Test
    void testProcessPaymentPositiveAmount() {
        double amount = 0.001;
    
        boolean result = cryptoPayment.processPayment(amount);
        assertTrue(result);
    }

    @Test
    void testProcessPaymentMediumAmount() {
        double amount = 150.75;
        
        boolean result = cryptoPayment.processPayment(amount);
        
        assertTrue(result);
    }

    @Test
    void testProcessPaymentHighAmount() {
        double amount = 50000.0;
        boolean result = cryptoPayment.processPayment(amount);
        assertTrue(result);
    }
}