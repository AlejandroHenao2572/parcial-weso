package eci.edu.dosw.parcial.util.factory;

import eci.edu.dosw.parcial.util.payment.Payment;
import eci.edu.dosw.parcial.util.payment.CryptoPayment;
import eci.edu.dosw.parcial.util.validator.PaymentValidator;
import eci.edu.dosw.parcial.util.validator.CryptoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CryptoFactoryTest {

    private CryptoFactory factory;

    @BeforeEach
    void setUp() {
        factory = new CryptoFactory();
    }

    @Test
    void testCreatePayment() {
        Payment payment = factory.createPayment();
        assertNotNull(payment);
        assertInstanceOf(CryptoPayment.class, payment);
    }

    @Test
    void testCreateValidator() {
        PaymentValidator validator = factory.createValidator();
        assertNotNull(validator);
        assertInstanceOf(CryptoValidator.class, validator);
    }

    @Test
    void testFactoryInheritance() {
        assertInstanceOf(PaymentFactory.class, factory);
    }
}