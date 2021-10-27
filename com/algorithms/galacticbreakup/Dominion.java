package com.algorithms.galacticbreakup;

public class Dominion {
    private Dominion parent;
    private Coordinate Coord;
    private int numChildren;


    public Dominion(Dominion parent) {
        this.parent = parent;
        this.numChildren = 0;
    }

    public Dominion() {
        this(null);
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

    public boolean hasParent() {
        return parent != null;
    }

    // Bascially findSet
    public Dominion getParent() throws NoParentException {
        if (parent == null) {
            throw new NoParentException("Dominion did not have parent.");
        }
        else {
            return parent;
        }
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

    public void setNMK(int dominion, int nlen, int mlen, int klen) {
        int n = dominion % nlen;
        int m = dominion / nlen % mlen;
        int k = dominion / nlen / mlen % klen;

        this.Coord = new Coordinate(n, m, k);   
    }

    public Coordinate getNMK() {
        return Coord;
    }
}
