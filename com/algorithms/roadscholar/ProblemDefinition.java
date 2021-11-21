package com.algorithms.roadscholar;

import java.util.Scanner;

/**
 * Input reader class for the road-scholar problem.
 * @author Andrew Huffman
 */
public class ProblemDefinition {
    private int numCities;
    private Node[] intersections;
    private Path[] roads;
    private Signpost[] signs;

    /**
     * Constructor.
     * @param input The scanner from which to derive the input.
     * @throws MalformedInputException If the input is of the wrong format.
     * @throws IndexOutOfBoundsException If any index is given outside of logical bounds.
     */
    public ProblemDefinition(Scanner input) throws MalformedInputException, IndexOutOfBoundsException {
        // I. Read the first line: n, m, k.
        // II. Read all paths.
        // III. Generate intersections.
        // IV. Assign cities.
        // V. Build signposts.

        // I. Read the first line: n, m, k.

        Helpers.assertHasNextInt(input, new MalformedInputException("Expected number of intersections"));
        int numIntersections = input.nextInt();
        Helpers.assertGreaterThanOrEqual(numIntersections, 1,
            new MalformedInputException("Number of intersections must be a positive integer"));
        this.intersections = new Node[numIntersections];

        Helpers.assertHasNextInt(input, new MalformedInputException("Expected number of roads"));
        int numRoads = input.nextInt();
        Helpers.assertGreaterThanOrEqual(numRoads, 1,
            new MalformedInputException("Number of roads must be a positive integer"));
        this.roads = new Path[numRoads];

        Helpers.assertHasNextInt(input, new MalformedInputException("Expected number of cities"));
        this.numCities = input.nextInt();
        Helpers.assertGreaterThanOrEqual(this.numCities, 1,
            new MalformedInputException("Number of cities must be a positive integer"));

        // II. Read all paths.
        
        for (int i = 0; i < roads.length; i++) {
            int a;
            int b;
            float w;

            Helpers.assertHasNextInt(input, new MalformedInputException("Expected node 'a' of path"));
            a = input.nextInt();

            Helpers.assertHasNextInt(input, new MalformedInputException("Expected node 'b' of path"));
            b = input.nextInt();

            Helpers.assertHasNextFloat(input, new MalformedInputException("Expected path weight"));
            w = input.nextFloat();

            roads[i] = new Path(a, b, w);
        }
        
        // III. Generate intersections.
        
        for (int i = 0; i < intersections.length; i++) {
            intersections[i] = new Node(i);
        }
        
        // IV. Assign cities.
        
        for (int i = 0; i < numCities; i++) {
            int index;
            String name;

            Helpers.assertHasNextInt(input, new MalformedInputException("Expected node index of city"));
            index = input.nextInt();
            Helpers.assertWithinRange(index, 0, intersections.length,
                new IndexOutOfBoundsException("City index was out of range of Nodes list"));

            Helpers.assertHasNextLine(input, new MalformedInputException("Expected city name"));
            name = input.nextLine();

            intersections[i].makeCity(name);
        }
        
        // V. Build signposts.
    
        Helpers.assertHasNextInt(input, new MalformedInputException("Expected number of signposts"));
        int numSigns = input.nextInt();
        Helpers.assertGreaterThanOrEqual(numSigns, 0,
            new MalformedInputException("Number of signposts should be a positive integer"));
        signs = new Signpost[numSigns];

        for (int i = 0; i < signs.length; i++) {
            int from;
            int to;
            float off;

            Helpers.assertHasNextInt(input, new MalformedInputException("Expected signpost source node"));
            from = input.nextInt();

            Helpers.assertHasNextInt(input, new MalformedInputException("Expected signpost to node"));
            to = input.nextInt();

            Helpers.assertHasNextFloat(input, new MalformedInputException("Expected signpost offset"));
            off = input.nextFloat();

            signs[i] = new Signpost(from, to, off);
        }
    }

    /**
     * Gets the number of signs defined in this problem.
     * @return The number of signs.
     */
    public int numSigns() {
        return signs.length;
    }

    /**
     * Solves the road-scholar problem at the specified index.
     * @param signIndex The index of the sign to solve for.
     * @return The string that should be written on the sign.
     * @throws IndexOutOfBoundsException if the index was out of bounds.
     */
    public String solve(int signIndex) throws IndexOutOfBoundsException {
        Helpers.assertWithinRange(signIndex, 0, signs.length, 
            new IndexOutOfBoundsException("Given sign index was out of bounds: " + signIndex));
        Signpost sign = signs[signIndex];

        float[][] best = new float[intersections.length][intersections.length];
        float[][] lastBest = new float[intersections.length][intersections.length];
        boolean[] isOnSign = new boolean[numCities];


    }
}
