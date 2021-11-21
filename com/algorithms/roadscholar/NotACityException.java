package com.algorithms.roadscholar;

/**
 * An exception, intended for use in the Road-scholar
 * problem, which is generated when a non-city node is
 * treated as a city.
 * @author Andrew Huffman
 */
public class NotACityException extends RuntimeException {
    public NotACityException(String str) {
        super(str);
    }
}
