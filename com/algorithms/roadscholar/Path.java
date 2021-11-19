package com.algorithms.roadscholar;


/**
 * A path in the road-scholar problem.
 * @author Andrew Huffman
 */
public class Path {
    private Node a;
    private Node b;
    private int dist;

    /**
     * Constructor.
     * @param a the first node along the path.
     * @param b the second node along the path.
     * @param distance the distance of the path.
     * @throws NullArgumentException if either Node is null.
     * @throws BadInputException if the distance is negative or zero.
     */
    public Path(Node a, Node b, int distance) throws NullArgumentException, BadInputException {
        // I. Null Checks
        // II. Check range on distance -- should be positive
        // III. Set arguments
    
        // I. Null Checks

        Helpers.nullCheck("a", a);
        Helpers.nullCheck("b", b);

        // II. Check range on distance -- should be positive

        Helpers.assertPositive(distance, "distance");

        // III. Set arguments

        this.a = a;
        this.b = b;
        this.dist = distance;
    }

    /**
     * Whether or not the given Node parameter is connected to this path.
     * @param n the node.
     * @return true if the node is along the path (either the first or the second).
     */
    public boolean hasNode(Node n) {
        return n == a || n == b;
    }



    // # GETTERS


    /**
     * Gets the distance along the path.
     * @return the distance.
     */
    public int getDistance() {
        return dist;
    }

    /**
     * Gets one node along the path.
     * @return the node.
     */
    public Node getNodeA() {
        return a;
    }

    /**
     * Gets one node along the path.
     * @return the node.
     */
    public Node getNodeB() {
        return b;
    }
}
