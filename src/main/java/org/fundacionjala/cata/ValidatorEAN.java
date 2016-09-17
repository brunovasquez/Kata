package org.fundacionjala.cata;

import java.util.stream.IntStream;


/**
 * Handles the calculates of area and perimeter.
 *
 * @autor Bruno Vasquez
 */
public class ValidatorEAN {
    private static final int LAST_DIGIT = 12;
    private static final int FACTOR_TEN = 10;
    private static final int ZERO = 0;
    private static final int FACTOR_THREE = 3;
    private static final int FACTOR_TWO = 2;
    private int totalSum;
    private String code;

    /**
     * It is the constructor of the validator.
     *
     * @param code an string to valid.
     */
    public ValidatorEAN(String code) {
        this.code = code;
        totalSum = 0;
        IntStream.range(0, this.code.length() - 1).forEach(index -> sum(index));
    }

    /**
     * Validates of code
     *
     * @return a boolean if the code is valid.
     */
    public boolean verifyChecksumWithLastDigit() {
        return checksum() == charToDigit(LAST_DIGIT);
    }

    /**
     * Checks the total sum of the digit
     *
     * @return the checksum.
     */
    public int checksum() {
        return (totalSum % FACTOR_TEN == ZERO) ? ZERO : FACTOR_TEN - (totalSum % FACTOR_TEN);
    }

    /**
     * Sums the digits according his position par or impair
     *
     * @param index a integer with the position of the digit
     */
    public void sum(int index) {
        totalSum += (index % FACTOR_TWO == ZERO) ? charToDigit(index) : charToDigit(index) * FACTOR_THREE;
    }

    /**
     * Casts the char digit to integer digit
     *
     * @param index a integer with the position of the digit
     * @return a integer digit.
     */
    public int charToDigit(int index) {
        return code.charAt(index) - '0';
    }
}
