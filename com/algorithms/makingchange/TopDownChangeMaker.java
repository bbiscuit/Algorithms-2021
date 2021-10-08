package com.algorithms.makingchange;

public class TopDownChangeMaker implements ChangeMaker {


    @Override
    public CoinPurse count(int value, DenominationSet set) {
        // 1. Base case: value is 0.
        // 2. For each denomination...
            // a. if the denomination is less than the value...
                // 1. Calculate the count of value - den.
        // 3. Return the minimum result of the givens.

        final int NUM_DENOMINATIONS = set.numDenominations();

        CoinPurse p;
        CoinPurse[] counts = new CoinPurse[NUM_DENOMINATIONS];

        // 1. Base case: value is 0.
        if (value == 0) {
            return new CoinPurse(set);
        }

        // 2. For each denomination...
        for (int i = 0; i < NUM_DENOMINATIONS; i++) {
            int den = set.get(i);

            // a. if the denomination is less than the value...
            if (den <= value) {

                // 2. Calculate the count of value - den.

                p = count(value - den, set);

                p = (CoinPurse)p.clone();
                p.addCoin(den);
                
            }
            else {
                p = null;
            }

            counts[i] = p;
        }

        // 3. Return the minimum result of the givens.
        return CoinPurse.minCoinCount(counts);
    }
}
