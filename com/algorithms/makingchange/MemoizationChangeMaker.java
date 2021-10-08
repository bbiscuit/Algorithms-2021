package com.algorithms.makingchange;

import java.util.Scanner;
import java.util.ArrayList;

public class MemoizationChangeMaker implements ChangeMaker {

    @Override
    public CoinPurse count(int value, DenominationSet set) {
        return count_r(value, set, new CoinPurse[value + 1]);
    }

    private CoinPurse count_r(int value, DenominationSet set, CoinPurse[] memArr) {
        // 1. Base case: value is 0.
        // 2. For each denomination...
            // a. if the denomination is less than the value...
                // 1. If the result of the count is cached, fetch that.
                // 2. Else, calculate said the count of value - den.
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

                // 1. If the result of the count is cached, fetch that.
                if (memArr[value - den] != null) {
                    p = memArr[value - den];
                    p = (CoinPurse)p.clone();
                    p.addCoin(den);
                }

                // 2. Else, calculate said the count of value - den.
                else {
                    p = count_r(value - den, set, memArr);
                    memArr[value - den] = p;

                    p = (CoinPurse)p.clone();
                    p.addCoin(den);
                }
            }
            else {
                p = null;
            }

            counts[i] = p;
        }

        // 3. Return the minimum result of the givens.
        return CoinPurse.minCoinCount(counts);
    }

    public static void main(String[] args) {
        System.out.print("Enter a denomination set (space delim): ");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        Scanner str = new Scanner(input);
        ArrayList<Integer> dens = new ArrayList<Integer>();

        while (str.hasNextInt()) {
            dens.add(str.nextInt());
        }
        str.close();

        int[] arr = new int[dens.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = dens.get(i);
        }
        
        DenominationSet set = new DenominationSet(arr);

        System.out.print("Enter a value to calc: ");
        input = s.nextLine();
        str = new Scanner(input);
        int val = str.nextInt();

        str.close();
        s.close();

        ChangeMaker cm = new TopDownChangeMaker();
        CoinPurse result = cm.count(val, set);

        System.out.println(result.getNumCoins());
        System.out.println(result.getTotal());
    }
}
