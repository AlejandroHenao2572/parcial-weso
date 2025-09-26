package eci.edu.dosw.parcial.util.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentDataTest {

    private PaymentData paymentData;

    @BeforeEach
    void setUp() {
        paymentData = new PaymentData(100.50, "creditcard", "TXN-123456");
    }

    @Test
    void testGetAmount() {
        double amount = paymentData.getAmount();
        assertEquals(100.50, amount);
    }

    @Test
    void testGetPaymentType() {
        String paymentType = paymentData.getPaymentType();
        assertEquals("creditcard", paymentType);
    }

    @Test
    void testGetTransactionId() {
        String transactionId = paymentData.getTransactionId();
        assertEquals("TXN-123456", transactionId);
    }

    @Test
    void testConstructorWithDifferentValues() {
        PaymentData data = new PaymentData(250.75, "paypal", "TXN-789012");
        assertEquals(250.75, data.getAmount());
        assertEquals("paypal", data.getPaymentType());
        assertEquals("TXN-789012", data.getTransactionId());
    }
}