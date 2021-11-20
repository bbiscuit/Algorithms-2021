package com.algorithms.roadscholar;

/**
 * A road-scholar map.
 * @author Andrew Huffman
 */
public class Map {
    private Node[] nodes;           // The nodes that make up the map.
    private Path[] paths;           // The paths which connect the nodes.


    /**
     * Constructor.
     * @param nodes The nodes which make up the map.
     * @param paths The paths which connect the nodes.
     * @throws NullArgumentException If either of the parameters or their
     * array contents are null.
     */
    public Map(Node[] nodes, Path[] paths) throws NullArgumentException {
        // I. Null check.
        // II. Copy the two arrays.
    
        // I. Null check.

        Helpers.nullCheck("nodes", nodes);
        Helpers.nullCheck("paths", paths);

        // II. Copy the two arrays.
    
        this.nodes = new Node[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            Helpers.nullCheck("nodes[" + i + "]", nodes[i]);

            this.nodes[i] = nodes[i];
        }

        this.paths = new Path[paths.length];
        for (int i = 0; i < paths.length; i++) {
            Helpers.nullCheck("paths[" + i + "]", paths[i]);

            this.paths[i] = paths[i];
        }
    }


    /**
     * Gets the number of nodes.
     * @return The size.
     */
    public int numNodes() {
        return nodes.length;
    }


    /**
     * Gets the number of paths.
     * @return the paths.
     */
    public int numPaths() {
        return paths.length;
    }


    /**
     * Gets the node at the index in the map.
     * @param index The index to get at.
     * @return The node.
     * @throws BadInputException If the given index was greater than or equal
     * to the number of nodes.
     */
    public Node getNode(int index) throws BadInputException {
        // I. Input check.
        // II. Return.

        // I. Input check.

        Helpers.assertLessThan(index, numNodes(), "index");

        // II. Return.

        return nodes[index];
    }


    /**
     * Gets the path at the index in the map.
     * @param index The index to get at.
     * @return The path.
     * @throws BadInputException If the given index is greater than or
     * equal to the number of paths.
     */
    public Path getPath(int index) throws BadInputException {
        // I. Input check.
        // II. Return.


        // I. Input check.

        Helpers.assertLessThan(index, numPaths(), "index");
        
        // II. Return.

        return paths[index];
    }
}
