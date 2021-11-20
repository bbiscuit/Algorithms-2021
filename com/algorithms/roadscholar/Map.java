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


    /**
     * Gets the index of the given node in the list.
     * @param n The node to check for.
     * @return The index of that node.
     * @throws NullArgumentException If the input node was null.
     * @throws BadInputException If the input was not in the array.
     */
    public int indexOf(Node n) throws NullArgumentException, BadInputException {
        // I. Null check.
        // II. Run through the array, and find the index of the node.
        // III. If nothing is found, throw.
    
        // I. Null check.

        Helpers.nullCheck("n", n);

        // II. Run through the array, and find the index of the node.

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == n) {
                return i;
            }
        }

        // III. If nothing is found, throw.

        throw new BadInputException("'n' was not in the list");
    }


    /**
     * Gets the index of the given path in the list.
     * @param p The path to check for.
     * @return The index of that path.
     * @throws NullArgumentException If the input node was path.
     * @throws BadInputException If the input was not in the array.
     */
    public int indexOf(Path p) throws NullArgumentException, BadInputException {
        // I. Null check.
        // II. Run through the array, and find the index of the path.
        // III. If nothing is found, throw.
    
        // I. Null check.

        Helpers.nullCheck("p", p);

        // II. Run through the array, and find the index of the path.

        for (int i = 0; i < paths.length; i++) {
            if (paths[i] == p) {
                return i;
            }
        }

        // III. If nothing is found, throw.

        throw new BadInputException("'p' was not in the list");
    }
}
