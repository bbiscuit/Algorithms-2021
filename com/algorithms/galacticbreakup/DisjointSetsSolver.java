package com.algorithms.galacticbreakup;

import java.util.Scanner;

/**
 * A class to solve Disjoint Sets problems in a 3D grid-space.
 * @author Andrew Huffman, Kyle Samuelson
 */
public class DisjointSetsSolver {
    Dominion[][][] domMatrix;
    int numSets = 0;

    /**
     * Constructor.
     * @param n The n-dimension of the grid-space.
     * @param m The m-dimension of the grid-space.
     * @param k The k-component of the grid-space.
     */
    public DisjointSetsSolver(int n, int m, int k) {
        if (n == 0 || m == 0 || k == 0) {
            throw new DisjointSetStateException("Invalid working space dimensions.");
        }

        domMatrix = new Dominion[n][m][k];
    }

    /**
     * Inserts a dominion value into the grid-space.
     * @param dominion the dominion to insert.
     */
    public void insert(int dominion) {
        // I. Build the dominion instance.
        // II. Insert value into the matrix, unioning sets if necessary.


        Dominion d;
        Coordinate c;

        // I. Build the dominion instance.
        d = new Dominion(dominion, domMatrix.length, domMatrix[0].length, domMatrix[0][0].length);

        // II. Insert value into matrix, unioning sets if necessary.
        c = d.getNMK();
        if (at(c) == null) {
            setAt(c, d);
            numSets++;
            tryUnion(d);
        }
    }

    /**
     * Gets the number of disjoint sets in the grid-space.
     */
    public int numDisjointSets() {
        return numSets;
    }

    /**
     * Searches for relationships with which to union based upon
     * the provided dominion. For this grid-space implementation,
     * unions will be done with adjacent coordinates.
     * @param d the dominion to search for unions.
     */
    void tryUnion(Dominion d) {
        Dominion[] adj = adjacencies(d);

        for (Dominion e : adj) {
            if (e != null) {
                union(d, e);
            }
        }
    }

    /**
     * Unions the two Dominions.
     * @param a the first Dominion.
     * @param b the second Dominion.
     */
    void union(Dominion a, Dominion b) {
        Dominion a_p = a.getRepresentative();
        Dominion b_p = b.getRepresentative();

        if (a_p != b_p) {
            a_p.setRepresentative(b_p);
            numSets--;
        }


    }

    /**
     * Gets an adjacency list given the coordinates of a valid dominion.
     * @param n the n coordinate.
     * @param m the m coordinate.
     * @param k the k coordinate.
     * @throws DisjointSetStateException If the value at n, m, k is null.
     */
    Dominion[] adjacencies(int n, int m, int k) throws DisjointSetStateException {
        // Param check
        if (domMatrix[n][m][k] == null) {
            throw new DisjointSetStateException("Disjoint set location specified should be non-null.");
        }

        // Initialize working variables
        Dominion[] adj = new Dominion[6];
        final int N_MAX = domMatrix.length;
        final int M_MAX = domMatrix[0].length;
        final int K_MAX = domMatrix[0][0].length;

        // Grab adjacencies, from n - 1 to n + 1 to m - 1 to m + 1 to k - 1 to k + 1
        adj[0] = (n == 0) ? null : domMatrix[n - 1][m][k];
        adj[1] = (n == N_MAX - 1) ? null : domMatrix[n + 1][m][k];
        adj[2] = (m == 0) ? null : domMatrix[n][m - 1][k];
        adj[3] = (m == M_MAX - 1) ? null : domMatrix[n][m + 1][k];
        adj[4] = (k == 0) ? null : domMatrix[n][m][k - 1];
        adj[5] = (k == K_MAX - 1) ? null : domMatrix[n][m][k + 1];

        return adj;
    }

    /**
     * Coordinate overload for adjacencies.
     * @param nmk the coordinate value.
     */
    Dominion[] adjacencies(Coordinate nmk) throws DisjointSetStateException {
        return adjacencies(nmk.getN(), nmk.getM(), nmk.getK());
    }

    /**
     * Dominion overload for adjacencies.
     * @param d the dominion value.
     */
    Dominion[] adjacencies(Dominion d) throws DisjointSetStateException {
        return adjacencies(d.getNMK());
    }

    /**
     * Gets the dominion at a certain coordinate.
     * @param c the coordinate
     * @return the dominion at c in the grid.
     */
    Dominion at(Coordinate c) {
        return domMatrix[c.getN()][c.getM()][c.getK()];
    }

    /**
     * Sets the dominion at a certain coordinate.
     * @param c the coordinate at which to insert.
     * @param val the value to insert at c.
     */
    void setAt(Coordinate c, Dominion val) {
        domMatrix[c.getN()][c.getM()][c.getK()] = val;
    }

    /**
     * Uses the DisjointSetsSolver data structure to solve the Galactic Breakup
     * programming contest problem.
     * @param pd the arguments for the problem.
     * @return the number of months in which the COBOL empire is fragmented, as
     * specified in the problem.
     */
    public static int galacticBreakup(ProblemDef pd) {
        int months = 0;
        DisjointSetsSolver s = new DisjointSetsSolver(pd.getNDimension(), pd.getMDimension(), pd.getKDimension());

        for (int i = pd.getNumSteps() - 1; i >= 0; i--) {
            for (int j = 0; j < pd.getNumDominionsInStep(i); j++) {
                s.insert(pd.getDominion(i, j));
            }

            if (s.numDisjointSets() > 1) {
                months++;
            }
        }

        return months;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        ProblemDef pd = new ProblemDef(s);

        System.out.println(DisjointSetsSolver.galacticBreakup(pd));
    }
}
