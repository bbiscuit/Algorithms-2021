package com.algorithms.makingchange;

import java.util.Scanner;

/**
 * A set of pre-defined denominations for a money system.
 * 
 * @author Andrew Huffman
 * @author Kyle Samuelson
 * @version Oct 4, 2021.
 */
public class DenominationSet {

    // CONSTRUCTORS
    
    public DenominationSet() {
        denominations = new int[]{1, 5, 10, 25};
    }

    public DenominationSet(int[] denominations) {
        this.denominations = new int[denominations.length];

        for (int i = 0; i < denominations.length; i++) {
            this.denominations[i] = denominations[i];
        }
    }

    // GETTERS

    public int numDenominations() {
        return denominations.length;
    }

    public int get(int index) {
        return denominations[index];
    }

    // STATICS

    public static DenominationSet parseDenominationSet(String str) {

        DenominationSet result;
        int[] denArr;
        int len;
        Scanner s;

        // Null check
        if (str == null) {
            throw new NullPointerException("str was null");
        }

        // Declare scanner
        s = new Scanner(str);
        
        // Declare array
        if (!s.hasNextInt()) {
            s.close();
            throw new DenominationSetException("malformed input list");
        }

        len = s.nextInt();
        denArr = new int[len];

        // Loop and copy denominations
        for (int i = 0; i < len; i++) {

            if (!s.hasNext()) {
                s.close();
                throw new DenominationSetException("malformed input list");
            }

            denArr[i] = s.nextInt();
        }

        // Create result
        result = new DenominationSet(denArr);
        
        s.close();
        return result;

    }


    
    private int[] denominations;
}
