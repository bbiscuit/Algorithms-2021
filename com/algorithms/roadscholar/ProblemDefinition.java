package com.algorithms.roadscholar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.ArrayList;

/**
 * Input reader class for the road-scholar problem.
 * @author Andrew Huffman
 */
public class ProblemDefinition {
    private int numCities;
    private Node[] intersections;
    private Path[] roads;
    private Signpost[] signs;

    private static final float INFINITY = 1E20f;

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
            name = input.nextLine().trim();

            intersections[index].makeCity(name);
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
    public String solve() {
        /*
        Helpers.assertWithinRange(signIndex, 0, signs.length, 
            new IndexOutOfBoundsException("Given sign index was out of bounds: " + signIndex));
        Signpost sign = signs[signIndex];*/

        float[][] best = new float[intersections.length][intersections.length];
        Node[] cityNodes = new Node[this.numCities];
        int[][] predecessor = new int[intersections.length][intersections.length];

        // Populate predecessor
        
        for (int i = 0; i < intersections.length; i++) {
            for (int j = 0; j < intersections.length; j++) {
                predecessor[i][j] = -1;
            }
        }

        // Fill the cities array

        for (int i = 0, j = 0; i < this.intersections.length; i++) {
            if (this.intersections[i].isCity()) {
                cityNodes[j] = this.intersections[i];
                j++;
            }
        }

        // Fill best

        for (int i = 0; i < best.length; i++) {
            for (int j = 0; j < best[i].length; j++) {
                best[i][j] = INFINITY;
            }
        }

        // Solve predecessor0 and best0

        for (int i = 0; i < intersections.length; i++) {
            for (int j = 0; j < intersections.length; j++) {
                float wgt = weight(i, j);
                
                if (wgt < INFINITY) {
                    best[i][j] = wgt;
                    best[j][i] = wgt;
                    predecessor[i][j] = i;
                    predecessor[j][i] = j;
                }
            }
        }

        // Floyd warshall

        for (int k = 0; k < intersections.length; k++) {
            for (int u = 0; u < intersections.length; u++) {
                for (int v = 0; v < intersections.length; v++) {
                    if (best[u][k] + best[k][v] < best[u][v]) {
                        best[u][v] = best[u][k] + best[k][v];
                        predecessor[u][v] = predecessor[k][v];
                    }
                }
            }
        }

        // Interpret results

        var results = new ArrayList<ArrayList<Tuple<Float, Node>>>(this.numSigns());
        
        for (var sign : signs) {
            var cityVals = new ArrayList<Tuple<Float, Node>>(this.numCities);

            Path p = new Path(sign.getSource(), sign.getTo(), 1.0f);
            for (var city : cityNodes) {
                if (p.endpointsMatch(sign.getSource(), predecessor[city.getIndex()][sign.getSource()])) {
                    cityVals.add(new Tuple<Float, Node>(best[sign.getSource()][city.getIndex()] - sign.getOffset(), city));
                }
            }
            results.add(cityVals);
        }

        
        StringBuilder sb = new StringBuilder();

        for (var result : results) {
            result.sort(new TupleFloatNodeComparator());
            for (var tuple : result) {
                float display = tuple.getKey();

                if (display - (int)display >= 0.5f) {
                    display += 1;
                }

                sb.append(String.format("%-20s%d\n", tuple.getVal().getCity(),(int)display));
            }
            sb.append('\n');
        }

        String finalString = sb.toString();

        // cut off the last newline
        return finalString.substring(0, finalString.length() - 2);
    }

    /**
     * Determines the weight of the edge between these two vertices,
     * or 1E20 if not found.
     * @param a Vertex a.
     * @param b Vertex b.
     * @return The weight value, or 1E20.
     */
    float weight(int a, int b) {
        if (a == b) {
            return 0.0f;
        }

        for (var e : roads) {
            if (e.endpointsMatch(a, b)) {
                return e.getWeight();
            }
        }

        return INFINITY;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("./test_in");
        Scanner s = new Scanner(f);

        ProblemDefinition pd = new ProblemDefinition(s);
        
        System.out.println(pd.solve());

        s.close();
    }
}
