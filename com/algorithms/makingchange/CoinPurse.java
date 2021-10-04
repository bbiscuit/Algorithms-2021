package com.algorithms.makingchange;

public class CoinPurse {
    
    public CoinPurse(DenominationSet set) {

        this.set = set;
        values = new int[set.numDenominations()];

    }

    public boolean hasDenomination(int den) {
        return at(den) != -1;
    }

    public void addCoin(int den) throws NoDenominationException {
        if (hasDenomination(den)) {
            values[at(den)]++;
        }
        else {
            throw new NoDenominationException("den not found");
        }
    }

    public int getNumCoins(int den) throws NoDenominationException {
        if (hasDenomination(den)) {
            return values[at(den)];
        }
        else {
            throw new NoDenominationException("den not found");
        }
    }

    public int getNumCoins() {

        int num = 0;

        for (int i = 0; i < values.length; i++) {
            num += values[i];
        }

        return num;
    }


    private DenominationSet set;
    private int[] values;

    private int at(int den) {
        for (int i = 0; i < set.numDenominations(); i++) {
            if (set.get(i) == den) {
                return i;
            }
        }

        return -1;
    }

}
