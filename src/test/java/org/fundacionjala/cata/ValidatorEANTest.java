package org.fundacionjala.cata;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link ValidatorEAN}
 */
public class ValidatorEANTest {

    @Test
    public void test_validate_true() {
        final String code = "9783815820865";
        ValidatorEAN validator = new ValidatorEAN(code);
        assertTrue(validator.verifyChecksumWithLastDigit());
    }

    @Test
    public void test_validate_false() {
        final String code = "9783815820864";
        ValidatorEAN validator = new ValidatorEAN(code);
        assertFalse(validator.verifyChecksumWithLastDigit());
    }

    @Test
    public void test_validate_otherTrue() {
        final String code = "9783827317100";
        ValidatorEAN validator = new ValidatorEAN(code);
        assertTrue(validator.verifyChecksumWithLastDigit());
    }
}