package com.algorithms.roadscholar;

/**
 * A signpost for the Road Scholar problem.
 */
public class Signpost {
    private Node source;            // The source of the road-scholar problem.
    private Path path;              // The path upon which the signpost is placed.


    /**
     * Constructor.
     * @param source The source node from which the sign starts.
     * @param path The path upon which the sign lies.
     * @throws NullArgumentException If either argument is null.
     */
    public Signpost(Node source, Path path) throws NullArgumentException {
        // I. Null checks.
        // II. Set private data.
    
        // I. Null checks.

        Helpers.nullCheck("source", source);
        Helpers.nullCheck("path", path);

        // II. Set private data.

        this.source = source;
        this.path = path;
    }

    // # GETTERS


    /**
     * Gets the source node for the road-scholar problem.
     * @return The source.
     */
    public Node getSource() {
        return source;
    }


    /**
     * Gets the path upon which the signpost lies.
     * @return The signpost.
     */
    public Path getPath() {
        return path;
    }
}
