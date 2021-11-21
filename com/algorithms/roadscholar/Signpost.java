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
