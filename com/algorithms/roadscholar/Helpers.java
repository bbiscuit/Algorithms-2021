package com.algorithms.roadscholar;

/**
 * Package-level helper method class.
 * @author Andrew Huffman
 */
class Helpers {
    /**
     * Checks if the given value is null, generating a NullArgumentException if not.
     * @param name the variable name of the value.
     * @param val the value.
     * @throws NullArgumentException if the value truly is null.
     */
    public static void nullCheck(String name, Object val) throws NullArgumentException {
        if (val == null) {
            throw new NullArgumentException("nonnull argument '" + name + "' was null");
        }
    }

    /**
     * Asserts that the given input is less than some max.
     * @param val the input.
     * @param lt the max.
     * @throws BadInputException If the value is less than the max.
     */
    public static void assertLessThan(int val, int lt, String name) throws BadInputException {
        if (val >= lt) {
            throw new BadInputException("'" + name + "', which was asserted less than " + lt
                + ", was " + val);
        }
    }

    /**
     * Asserts that the given input is positive.
     * @param val the value to check.
     * @throws BadInputException if the input was negative or zero.
     */
    public static void assertPositive(int val, String name) throws BadInputException {
        if (val <= 0) {
            throw new BadInputException("'" + name + "', a value asserted positive, was " + val);
        }
    }
}
