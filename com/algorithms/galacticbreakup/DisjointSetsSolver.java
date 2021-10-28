package com.algorithms.galacticbreakup;

import java.util.Scanner;

public class DisjointSetsSolver {
    Dominion[][][] domMatrix;
    int numSets = 0;

    public DisjointSetsSolver(int n, int m, int k) {
        if (n == 0 || m == 0 || k == 0) {
            throw new DisjointSetStateException("Invalid working space dimensions.");
        }

        domMatrix = new Dominion[n][m][k];
    }

    public void insert(int dominion) {
        // Build the dominion instance.
        // Insert value into matrix
        // If this value is not currently in our forest...
            // Insert into forest.

        Dominion d;
        Coordinate c;


        // Build the dominion instance.
        d = new Dominion(dominion, domMatrix.length, domMatrix[0].length, domMatrix[0][0].length);

        // Insert value into matrix
        c = d.getNMK();
        if (at(c) == null) {
            setAt(c, d);
            numSets++;
            tryUnion(d);
        }
    }

    public int numDisjointSets() {
        return numSets;
    }

    void tryUnion(Dominion d) {
        Dominion[] adj = adjacencies(d);

        for (Dominion e : adj) {
            if (e != null) {
                union(d, e);
            }
        }
    }

    void union(Dominion a, Dominion b) {
        Dominion a_p = a.getRepresentative();
        Dominion b_p = b.getRepresentative();

        if (a_p != b_p) {
            a_p.setParent(b_p);
            numSets--;
        }


    }

    Dominion[] adjacencies(int n, int m, int k) {
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

    Dominion[] adjacencies(Coordinate nmk) {
        return adjacencies(nmk.getN(), nmk.getM(), nmk.getK());
    }

    Dominion[] adjacencies(Dominion d) {
        return adjacencies(d.getNMK());
    }



    Dominion at(Coordinate c) {
        return domMatrix[c.getN()][c.getM()][c.getK()];
    }

    void setAt(Coordinate c, Dominion val) {
        domMatrix[c.getN()][c.getM()][c.getK()] = val;
    }

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
