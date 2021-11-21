package com.algorithms.roadscholar;

/**
 * Helper methods, mainly used for exception generation, for use in
 * the road-scholar problem.
 * @author Andrew Huffman
 */
public class Helpers {
    public static void assertNotNull(Object val, RuntimeException e) {
        if (val == null) {
            throw e;
        }
    }
}
