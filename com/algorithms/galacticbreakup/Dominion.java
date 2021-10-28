package com.algorithms.galacticbreakup;

/**
 * A dominion in an independent COBOL monarchy, as specified in
 * the Galactic Breakup programming problem.
 * In reality, this is very similar to a tree node with an xyz (or nmk)
 * coordinate.
 * @author Andrew Huffman, Kyle Samuelson
 */
public class Dominion {
    private Dominion parent;
    private Coordinate coord;

    /**
     * Constructor.
     * @param number the dominion number (1D index).
     * @param n the maximum n coordinate of the grid-space.
     * @param m the maximum m coordinate of the grid-space.
     * @param k the maximum k coordinate of the grid-space.
     */
    public Dominion(int number, int n, int m, int k) {
        setNMK(number, n, m, k);
        parent = this;
    }

    /**
     * Gets this Dominion's representative node.
     * @return the representative.
     */
    public Dominion getRepresentative() {
        return getRepresentative_r(this);
    }

    /**
     * Recursive routine to calculate the representative
     * while flattening the tree.
     * @param x the current dominion in the recursion
     * @return the representative.
     */
    Dominion getRepresentative_r(Dominion x) {
        if (x != x.parent()) {
            x.setParent(getRepresentative_r(x.parent()));
        }
        return x.parent();
    }

    /**
     * Gets the immediate parent of the representative.
     * @return the parent.
     */
    Dominion parent() {
        return parent;
    }

    /**
     * Sets the immediate parent of the dominion.
     * @param p the dominion to become the immediate parent.
     */
    public void setParent(Dominion p) {
        this.parent = p;
    }

    /**
     * Helper routine to set NMK values based on a 1D index.
     * @param dominion the dominion number.
     * @param nlen the maximum n length on the grid.
     * @param mlen the maximum m length on the grid.
     * @param klen the maximum k length on the grid.
     */
    private void setNMK(int dominion, int nlen, int mlen, int klen) {
        int n = dominion % nlen;
        int m = (dominion / nlen) % mlen;
        int k = dominion / (nlen * mlen);

        this.coord = new Coordinate(n, m, k);   
    }

    /**
     * Gets the NMK coordinates of the dominion.
     * @return the coordinate.
     */
    public Coordinate getNMK() {
        return coord;
    }
}
