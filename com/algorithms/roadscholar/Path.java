package com.algorithms.roadscholar;

/**
 * A path connecting two indexed nodes in the road-scholar problem.
 * @author Andrew Huffman
 */
public class Path {
    private int indexA;     // The index of the first node along the path.
    private int indexB;     // The index of the second node along the path.
    private float weight;   // The weight of the path.

    /**
     * Constructor.
     * @param indexA The index of the first node along the path.
     * @param indexB The index of the second node along the path.
     * @param weight The weight of the path.
     * @throws IndexOutOfBoundsException If either index is negative.
     * @throws NegativeWeightException If the weight is negative.
     */
    public Path(int indexA, int indexB, float weight) throws IndexOutOfBoundsException, NegativeWeightException {
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

    public boolean endpointsMatch(int a, int b) {
        return (this.indexA == a && this.indexB == b) || (this.indexA == b && this.indexB == a);
    }
}
