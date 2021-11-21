package com.algorithms.roadscholar;

/**
 * A path connecting two indexed nodes in the road-scholar problem.
 * @author Andrew Huffman
 */
public class Path {
    private int indexA;     // The index of the first node along the path.
    private int indexB;     // The index of the second node along the path.
    private float weight;   // The weight of the path.

    public Path(int indexA, int indexB, float weight) {
        Helpers.assertGreaterThanOrEqual(indexA, 0, 
            new IndexOutOfBoundsException("'indexA' must be greater than or equal to 0. Val: " + indexA));
        Helpers.assertGreaterThanOrEqual(indexB, 0, 
            new IndexOutOfBoundsException("'indexB' must be greater than or equal to 0. Val : " + indexB));
        Helpers.assertGreaterThanOrEqual(weight, 0.0f, 
            new NegativeWeightException("Weights cannot be negative. Weight value: " + weight));
        
        this.indexA = indexA;
        this.indexB = indexB;
        this.weight = weight;
    }

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

    /**
     * Gets the weight (length) of the path.
     * @return The weight of the path.
     */
    public float getWeight() {
        return weight;
    }
}
