package com.algorithms.roadscholar;

/**
 * Exception generated if a node in the road-scholar problem is treated as
 * a city when it is, in fact, not.
 */
public class NoCityException extends RuntimeException {
    public NoCityException(String str) {
        super(str);
    }
}
