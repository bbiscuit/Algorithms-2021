package com.algorithms.galacticbreakup;

public class Dominion {
    private Dominion parent;
    private Coordinate Coord;

    public Dominion(int number, int n, int m, int k) {
        setNMK(number, n, m, k);
        parent = this;
    }


    public Dominion getRepresentative() {
        return getRepresentative_r(this);
    }

    Dominion getRepresentative_r(Dominion x) {
        if (x != x.parent()) {
            x.setRepresentative(getRepresentative_r(x.parent()));
        }
        return x.parent();
    }

    Dominion parent() {
        return parent;
    }

    public void setRepresentative(Dominion p) {
        this.parent = p;
    }

    private void setNMK(int dominion, int nlen, int mlen, int klen) {
        int n = dominion % nlen;
        int m = (dominion / nlen) % mlen;
        int k = dominion / (nlen * mlen);

        this.Coord = new Coordinate(n, m, k);   
    }

    public Coordinate getNMK() {
        return Coord;
    }
}
