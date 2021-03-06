package com.algorithms.makingchange;

import java.util.Scanner;
import java.util.ArrayList;

public class BottomUpChangeMaker implements ChangeMaker {

    @Override
    public CoinPurse count(int value, DenominationSet set) {
        // 1. Initialize the dynamic array.
        // 2. Seed the first value with an empty purse.
        // 3. For each member in the array past one...
            // a. For each denomination in the set...
                // 1. If the denomination is less than the current value,
                // find its coin purse and add it to the working 'counts'
                // array. Else, add nullptr.
            // b. Determine the solution with the least coins, and set it to
            // the value in the array.
            
        
        CoinPurse[] array;
        CoinPurse p;
        CoinPurse[] counts;
        
        final int NUM_DENS = set.numDenominations();

        // 1. Initialize the dynamic array.
        array = new CoinPurse[value + 1];
        counts = new CoinPurse[NUM_DENS]; 

        // 2. Seed the first value with an empty purse.
        p = new CoinPurse(set);
        array[0] = p;

        // 3. For each member in the array past one...
        for (int i = 1; i <= value; i++) {

            // a. For each denomination in the set...
            for (int j = 0; j < NUM_DENS; j++) {

                // 1. If the denomination is less than the current value,
                // find its coin purse and add it to the working 'counts'
                // array. Else, add nullptr.

                int den = set.get(j);

                if (den <= i) {
                    p = array[i - den];
                    p = (CoinPurse)p.clone();
                    p.addCoin(den);

                }
                else {
                    p = null;
                }

                counts[j] = p;
            }

            // b. Determine the solution with the least coins, and set it to
            // the value in the array.
            array[i] = CoinPurse.minCoinCount(counts);
        }

        return array[value];
    }
}
