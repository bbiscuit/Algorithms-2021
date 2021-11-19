package com.algorithms.roadscholar;

import java.util.ArrayList;

/**
 * A node on the graph for the road-scholar problem.
 * @author Andrew Huffman
 */
public class Node {
    private String cityName;                                        // The name of the city, or 
                                                                    // null if not a city.
    private ArrayList<Path> outgoingPaths;                          // All paths leaving this node.

    private static final int DEFAULT_OUTGOING_PATHS_CAPCITY = 5;    // The default capacity of the
                                                                    // 'outgoingPaths' arraylist.

    /**
     * Constructor.
     * @param cityName the name of the city.
     * @throws NullArgumentException if the city name is null.
     */
    public Node(String cityName) throws NullArgumentException {
        // I. null check
        // II. set data

        // I. null check

        Helpers.nullCheck("cityName", cityName);

        // II. set data

        this.cityName = cityName;
        constructOutgoingPaths();
    }


    /**
     * Constructor.
     */
    public Node() {
        this.cityName = null;
        constructOutgoingPaths();
    }


    /**
     * Whether or not the given intersection contains a city
     * @return true if it contains a city
     */
    public boolean containsCity() {
        return cityName != null;
    }


    /**
     * Adds an outgoing path to the node.
     * @param p the path to add.
     * @throws NullArgumentException if the given path was null.
     */
    public void addPath(Path p) throws NullArgumentException {
        // I. Null check
        // II. add the path to the arraylist.
    
        // I. Null check

        Helpers.nullCheck("p", p);

        // II. add the path to the arraylist.
    
        outgoingPaths.add(p);
    }


    /**
     * Gets the number of outgoing paths on the node.
     * @return the number of paths.
     */
    public int numPaths() {
        return outgoingPaths.size();
    }


    /**
     * Gets the path at the index.
     * @param index
     * @return
     */
    public Path getPath(int index) {
        Helpers.assertLessThan(index, numPaths(), "index");

        return outgoingPaths.get(index);
    } 


    /**
     * Gets the name of the city at the node.
     * @return the city name.
     * @throws NoCityException if this node does not contain a city.
     */
    public String getCity() throws NoCityException {
        if (cityName == null) {
            throw new NoCityException("Node did not contain a city.");
        }
        else {
            return cityName;
        }
    }

    /**
     * Helper constructor method to build the outgoingPaths arraylist for the
     * sake of homogeneity.
     */
    private void constructOutgoingPaths() {
        this.outgoingPaths = new ArrayList<Path>(DEFAULT_OUTGOING_PATHS_CAPCITY);
    }
}