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
}
