package com.algorithms.galacticbreakup;

public class Coordinate {
    private int n;
    private int m;
    private int k;

    public Coordinate(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int getK() {
        return k;
    }

    @Override
    public String toString() {
        return "(" + n + ", " + m + ", " + k + ")";
    }
}
