package com.algorithms.galacticbreakup;

public class Dominion {
    private Dominion parent;

    public Dominion(Dominion parent) {
        this.parent = parent;
    }

    public Dominion() {
        this(null);
    }

    public boolean hasParent() {
        return parent != null;
    }

    public Dominion getParent() throws NoParentException {
        if (parent == null) {
            throw new NoParentException("Dominion did not have parent.");
        }
        else {
            return parent;
        }
    }

    public static Coordinate getNMK(int dominion, int nlen, int mlen, int klen) {
        int n = dominion % nlen;
        int m = dominion / nlen % mlen;
        int k = dominion / nlen / mlen % klen;

        return new Coordinate(n, m, k);
        
    }
}
