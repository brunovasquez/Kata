package org.fundacionjala.cata;

import java.util.stream.IntStream;

/**
 * Validates of a checksum of a code.
 *
 * @autor Bruno Vasquez
 */
public class ValidatorEAN {
    private static final int LAST_DIGIT = 12;
    private static final int FACTOR_TEN = 10;
    private static final int ZERO = 0;
    private static final int FACTOR_THREE = 3;
    private static final int FACTOR_TWO = 2;
    private int totalSum = 0;
    private String code;

    /**
     * Validates of code
     *
     * @param code an string to valid.
     * @return a boolean if the code is valid.
     */
    boolean verifyChecksumWithLastDigit(String code) {
        this.code = code;
        IntStream.range(0, code.length() - 1).forEach(this::sum);
        return checksum() == charToDigit(LAST_DIGIT);
    }

    /**
     * Checks the total sum of the digit
     *
     * @return the checksum.
     */
    private int checksum() {
        return (totalSum % FACTOR_TEN == ZERO) ? ZERO : FACTOR_TEN - (totalSum % FACTOR_TEN);
    }

    /**
     * Sums the digits according their positions par or impair
     *
     * @param index a integer with the position of the digit
     */
    private void sum(int index) {
        totalSum += (index % FACTOR_TWO == ZERO) ? charToDigit(index) : charToDigit(index) * FACTOR_THREE;
    }

    /**
     * Casts the char digit to integer digit
     *
     * @param index a integer with the position of the digit
     * @return a integer digit.
     */
    private int charToDigit(int index) {
        return code.charAt(index) - '0';
    }
}
