package com.algorithms.galacticbreakup;

/**
 * A simple coordinate in a three-dimensional array.
 * @author Andrew Huffman, Kyle Samuelson
 */
public class Coordinate {
    private int n;
    private int m;
    private int k;

    /**
     * Constructor.
     * @param n The n-component of the coordinate.
     * @param m The m-component of the coordinate.
     * @param k The k-component of the coordinate.
     */
    public Coordinate(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
    }

    /**
     * Gets the n-component of the coordinate.
     * @return The n-component.
     */
    public int getN() {
        return n;
    }

    /**
     * Gets the m-component of the coordinate.
     * @return The m-component.
     */
    public int getM() {
        return m;
    }

    /**
     * Gets the k-component of the coordinate.
     * @return The k-component.
     */
    public int getK() {
        return k;
    }

    /**
     * toString override of type Coordinate.
     */
    @Override
    public String toString() {
        return "(" + n + ", " + m + ", " + k + ")";
    }
}
