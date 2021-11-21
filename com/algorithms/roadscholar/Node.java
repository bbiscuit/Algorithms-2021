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

    /**
     * Gets the name of the city at this node, if it truly
     * is a city.
     * @return The city name.
     * @throws NotACityException If the node was not a city.
     */
    public String getCity() throws NotACityException {
        if (name == null) {
            throw new NotACityException("The node queried was not a city node");
        }
        else {
            return name;
        }
    }

    /**
     * Gets the index of the node, for use in floyd-warshall.
     * @return The index.
     */
    public int getIndex() {
        return index;
    }
}
