package org.fundacionjala.cata;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link ValidatorEAN}
 */
public class ValidatorEANTest {

    private ValidatorEAN validator;
    @Before
    public void setup(){
        validator = new ValidatorEAN();
    }
    @Test
    public void test_validate_true() {
        final String code = "9783815820865";
       assertTrue(validator.verifyChecksumWithLastDigit(code));
    }

    @Test
    public void test_validate_false() {
        final String code = "9783815820864";
        assertFalse(validator.verifyChecksumWithLastDigit(code));
    }

    @Test
    public void test_validate_otherTrue() {
        final String code = "9783827317100";
        assertTrue(validator.verifyChecksumWithLastDigit(code));
    }
}