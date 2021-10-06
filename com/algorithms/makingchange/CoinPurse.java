package com.algorithms.makingchange;

public class CoinPurse {
    
    public CoinPurse(DenominationSet set) {

        this.set = set;
        values = new int[set.numDenominations()];

    }

    public CoinPurse(DenominationSet set, int[] vals) {
        this.set = set;
        values = new int[vals.length];
        for (int i = 0; i < vals.length; i++) {
            values[i] = vals[i];
            numCoins += vals[i];
            total += vals[i] * set.get(i);
        }
        
    }

    /**
     * Adds the backing values of this coin purse with another
     * and returns the result.
     * @param o The other coin purse to add by.
     * @throws DenominationSetException if the two CoinPurses have
     * differing denomination sets.
     */
    public CoinPurse add(CoinPurse o) throws DenominationSetException {
        // 1. Check whether the given CoinPurse can be added to the current
        // instance.
        // 2. Add values.
        // 3. Construct result & return.

        int[] resultingValues;
        CoinPurse result;

        // 1. Check whether the given CoinPurse can be added to the current
        // instance.
        if (!o.denSet().equals(set)) {
            throw new DenominationSetException("DenominationSets must be equal for addition.");
        }

        // 2. Add values.
        resultingValues = new int[values.length];
        for (int i = 0; i < set.numDenominations(); i++) {
            int den = set.get(i);

            int thisCoins = getNumCoins(den);
            int oCoins = o.getNumCoins(den);

            resultingValues[at(den)] = thisCoins + oCoins;
        }

        // 3. Construct result & return.
        result = new CoinPurse(set, resultingValues);
        return result;
    }

    /**
     * Gets the denominationSet of the CoinPurse.
     * @return The denominationSet of the CoinPurse.
     */
    public DenominationSet denSet() {
        return set;
    }

    /**
     * True if the coin purse has a specified denomination.
     * @param den The denomination to check.
     * @return True if a coin of denomination 'den' exists.
     */
    public boolean hasDenomination(int den) {
        return at(den) != -1;
    }

    /**
     * Adds a coin of the specified denomination.
     * @param den The denomination to add.
     * @throws NoDenominationException If the denomination of coin
     * 'den' does not exist.
     */
    public void addCoin(int den) throws NoDenominationException {
        if (hasDenomination(den)) {
            values[at(den)]++;
            total += den;
            numCoins++;
        }
        else {
            throw new NoDenominationException("den not found");
        }
    }

    /**
     * Gets the number of coins gathered of a specified denominations.
     * @param den The denomination to check.
     * @return The amount of coins gathered of denomination 'den'.
     * @throws NoDenominationException If the denomination of coin
     * 'den' does not exist.
     */
    public int getNumCoins(int den) throws NoDenominationException {
        if (hasDenomination(den)) {
            return values[at(den)];
        }
        else {
            throw new NoDenominationException("den not found");
        }
    }

    /**
     * Gets the total number of coins in the purse.
     * @return The total number of coins in the purse (all
     * denominations)
     */
    public int getNumCoins() {
        return numCoins;
    }


    /**
     * Gets the total monetary value contained within the purse
     * @return the total.
     */
    public int getTotal() {
        return total;
    }

    @Override
    public Object clone() {
        CoinPurse c = new CoinPurse(set, values);

        return c;
    }

    /**
     * Returns the CoinPurse with the least amount of coins.
     * @param o The other coin purse.
     * @return The minimum coin purse.
     */
    public CoinPurse minCoinCount(CoinPurse o) {
        return getNumCoins() > o.getNumCoins() ? o : this; 
    }

    public static CoinPurse minCoinCount(CoinPurse[] purses) {
        if (purses.length == 0) {
            return null;
        }

        CoinPurse min = purses[0];
        for (int i = 1; i < purses.length; i++) {
            if (purses[i] != null && purses[i].getNumCoins() < min.getNumCoins()) {
                min = purses[i];
            }
        }

        return min;
        
    }


    private DenominationSet set;
    private int[] values;
    private int numCoins = 0;
    private int total = 0;

    private int at(int den) {
        for (int i = 0; i < set.numDenominations(); i++) {
            if (set.get(i) == den) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        
    }

}
