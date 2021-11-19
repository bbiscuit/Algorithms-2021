package com.algorithms.roadscholar;

/**
 * Exception generated when bad (out-of-range, malformatted, etc.) input
 * is given.
 */
public class BadInputException extends RuntimeException {
    public BadInputException(String str) {
        super(str);
    }
}
