package com.algorithms.roadscholar;

/**
 * Exception generated when a negative weight is given to a path in the
 * road-scholar problem.
 * @author Andrew Huffman
 */
public class NegativeWeightException extends RuntimeException {
    public NegativeWeightException(String str) {
        super(str);
    }
    
}
