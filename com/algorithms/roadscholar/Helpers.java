package com.algorithms.roadscholar;

import java.util.Scanner;

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

    public static void assertGreaterThanOrEqual(int val, int base, RuntimeException e) {
        if (val < base) {
            throw e;
        }
    }

    public static void assertGreaterThanOrEqual(float val, float base, RuntimeException e) {
        if (val <= base) {
            throw e;
        }
    }

    public static void assertLessThan(int val, int base, RuntimeException e) {
        if (val >= base) {
            throw e;
        }
    }

    public static void assertHasNextInt(Scanner s, RuntimeException e) {
        if (!s.hasNextInt()) {
            throw e;
        }
    }

    public static void assertHasNextFloat(Scanner s, RuntimeException e) {
        if (!s.hasNextFloat()) {
            throw e;
        }
    }

    public static void assertHasNextLine(Scanner s, RuntimeException e) {
        if (!s.hasNextLine()) {
            throw e;
        }
    }
}
