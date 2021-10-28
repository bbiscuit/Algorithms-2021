package com.algorithms.galacticbreakup;

public class DisjointSetsSolver {
    Dominion[][][] domMatrix;

    public DisjointSetsSolver(int n, int m, int k) {
        if (n == 0 || m == 0 || k == 0) {
            throw new DisjointSetStateException("Invalid working space dimensions.");
        }

        domMatrix = new Dominion[n][m][k];
    }

    public void insert(Dominion d) {
        
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

    
}
