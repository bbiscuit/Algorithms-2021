package com.algorithms.roadscholar;

/**
 * A node in the road-scholar problem.
 * @author Andrew Huffman
 */
public class Node {
    private String name;        // The name of the string, or null if there's no city at this node.
    private int index;          // The index of the node; used in floyd-warshall.

    /**
     * Constructor. Recall that the node has to be made a city
     * post-construction!
     * @param index The index for use in floyd-warshall.
     * @throws IndexOutOfBoundsException If the index is less than 0.
     */
    public Node(int index) throws IndexOutOfBoundsException {
        Helpers.assertGreaterThanOrEqual(index, 0, new IndexOutOfBoundsException("'index' must be greater than or equal to 0"));

        this.index = index;
        this.name = null;
    }

    /**
     * Makes a node city-bearing.
     * @param name The name of the city.
     */
    public void makeCity(String name) {
        Helpers.assertNotNull(name, new NullInputException("Non-null input 'name' was null"));

        this.name = name;
    }

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
