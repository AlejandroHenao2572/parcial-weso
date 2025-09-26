package eci.edu.dosw.parcial.util.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreditCardValidatorTest {

    private CreditCardValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CreditCardValidator();
    }

    @Test
    void testValidateReturnTrue() {
        boolean result = validator.validate();
        assertTrue(result);
    }

    @Test
    void testValidatorInheritance() {
        assertInstanceOf(PaymentValidator.class, validator);
    }

    @Test
    void testValidateConsistency() {
        boolean result1 = validator.validate();
        boolean result2 = validator.validate();
        assertEquals(result1, result2);
    }
}