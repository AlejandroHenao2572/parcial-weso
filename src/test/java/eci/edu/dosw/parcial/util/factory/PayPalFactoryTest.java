package eci.edu.dosw.parcial.util.factory;

import eci.edu.dosw.parcial.util.payment.Payment;
import eci.edu.dosw.parcial.util.payment.PayPalPayment;
import eci.edu.dosw.parcial.util.validator.PaymentValidator;
import eci.edu.dosw.parcial.util.validator.PayPalValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PayPalFactoryTest {

    private PayPalFactory factory;

    @BeforeEach
    void setUp() {
        factory = new PayPalFactory();
    }

    @Test
    void testCreatePayment() {
        Payment payment = factory.createPayment();
        assertNotNull(payment);
        assertInstanceOf(PayPalPayment.class, payment);
    }

    @Test
    void testCreateValidator() {
        PaymentValidator validator = factory.createValidator();
        assertNotNull(validator);
        assertInstanceOf(PayPalValidator.class, validator);
    }

    @Test
    void testFactoryInheritance() {
        assertInstanceOf(PaymentFactory.class, factory);
    }
}