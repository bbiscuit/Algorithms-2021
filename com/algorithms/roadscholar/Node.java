package com.algorithms.roadscholar;

/**
 * A node in the road-scholar problem.
 * @author Andrew Huffman
 */
public class Node {
    private String name;        // The name of the string, or null if there's no city at this node.
    private int index;          // The index of the node; used in floyd-warshall.

    /**
     * Whether or not the node is a city.
     * @return True if the node is a city node.
     */
    public boolean isCity() {
        return name != null;
    }
}
