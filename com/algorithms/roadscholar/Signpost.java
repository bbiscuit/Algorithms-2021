package com.algorithms.roadscholar;

/**
 * A signpost for the Road-scholar problem.
 * @author Andrew Huffman
 */
public class Signpost {
    private int sourceIndex;        // The index of the source node.
    private float offset;           // The offset of the sign from the source.
    private int toIndex;            // The index of the node at the end of the path.

    /**
     * Constructor.
     * @param sourceIndex The index of the source node.
     * @param toIndex The index of the node at the end of the path.
     * @param offset The offset of the sign from the source.
     * @throws IndexOutOfBoundsException If either index is 0.
     * @throws NegativeWeightException If the given offset weight is negative.
     */
    public Signpost(int sourceIndex, int toIndex, float offset) throws IndexOutOfBoundsException, NegativeWeightException {
        Helpers.assertGreaterThanOrEqual(sourceIndex, 0, 
            new IndexOutOfBoundsException("'sourceIndex' must be greater than 0. Val: " + sourceIndex));
        Helpers.assertGreaterThanOrEqual(toIndex, 0, 
            new IndexOutOfBoundsException("'toIndex' must be greater than 0. Val: " + toIndex));
        Helpers.assertGreaterThanOrEqual(offset, 0.0f, 
            new NegativeWeightException("Offset weight must be positive. Val: " + offset));
        
        this.sourceIndex = sourceIndex;
        this.toIndex = toIndex;
        this.offset = offset;
    }

    /**
     * Gets the idnex of the source node.
     * @return The source index.
     */
    public int getSource() {
        return sourceIndex;
    }

    /**
     * Gets the index of the node at the end of the path
     * upon which this sign is found.
     * @return The 'to' index.
     */
    public int getTo() {
        return toIndex;
    }

    /**
     * Gets how far the signpost is along the path it's on.
     * @return The offset.
     */
    public float getOffset() {
        return offset;
    }
}
