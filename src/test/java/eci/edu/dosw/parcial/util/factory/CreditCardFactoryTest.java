package eci.edu.dosw.parcial.util.factory;

import eci.edu.dosw.parcial.util.payment.Payment;
import eci.edu.dosw.parcial.util.payment.CreditCardPayment;
import eci.edu.dosw.parcial.util.validator.PaymentValidator;
import eci.edu.dosw.parcial.util.validator.CreditCardValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreditCardFactoryTest {

    private CreditCardFactory factory;

    @BeforeEach
    void setUp() {
        factory = new CreditCardFactory();
    }

    @Test
    void testCreatePayment() {
        Payment payment = factory.createPayment();
        assertNotNull(payment);
        assertInstanceOf(CreditCardPayment.class, payment);
    }

    @Test
    void testCreateValidator() {
        PaymentValidator validator = factory.createValidator();
        assertNotNull(validator);
        assertInstanceOf(CreditCardValidator.class, validator);
    }

    @Test
    void testFactoryInheritance() {
        assertInstanceOf(PaymentFactory.class, factory);
    }
}