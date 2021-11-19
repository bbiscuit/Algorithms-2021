package com.algorithms.roadscholar;

/**
 * Exception generated when an argument to a method is null.
 * @author Andrew Huffman
 */
public class NullArgumentException extends RuntimeException {
    public NullArgumentException(String str) {
        super(str);
    }
}
