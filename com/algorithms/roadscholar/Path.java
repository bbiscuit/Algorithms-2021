package com.algorithms.roadscholar;

/**
 * A path connecting two indexed nodes in the road-scholar problem.
 * @author Andrew Huffman
 */
public class Path {
    private int indexA;     // The index of the first node along the path.
    private int indexB;     // The index of the second node along the path.

    /**
     * Gets the index for the first node along the path.
     * @return The index of the first node along the path.
     */
    public int getA() {
        return indexA;
    }

    /**
     * Gets the index for the second node along the path.
     * @return The index of the second node along the path.
     */
    public int getB() {
        return indexB;
    }
}
