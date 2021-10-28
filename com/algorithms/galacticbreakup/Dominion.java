package com.algorithms.galacticbreakup;

public class Dominion {
    private Dominion parent;
    private Coordinate Coord;
    private int numChildren;

    public Dominion(int number, int n, int m, int k) {
        setNMK(number, n, m, k);
        parent = this;
        numChildren = 0;
    }

    public void incrementServants(int currentChildren){
        this.numChildren = numChildren + currentChildren + 1;
    }

    public void looseServants(){
        this.numChildren = 0;
    }

    public int getServants(){
        return numChildren;
    }

    @Deprecated
    public boolean hasParent() {
        return parent != null;
    }

    @Deprecated
    // Bascially findSet
    public Dominion getParent() throws NoParentException {
        if (parent == null) {
            throw new NoParentException("Dominion did not have parent.");
        }
        else {
            return parent;
        }
    }

    public Dominion getRepresentative() {
        return getRepresentative_r(this);
    }

    Dominion getRepresentative_r(Dominion x) {
        if (x != x.parent()) {
            x.setParent(getRepresentative_r(x.parent()));
        }
        return x.parent();
    }

    Dominion parent() {
        return parent;
    }

    public void setParent(Dominion p) {
        this.parent = p;
    }

    public Dominion findKingdom() {
        Dominion p = this;
        while (p.hasParent()) {
            p = p.getParent();
        }

        return p;
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
