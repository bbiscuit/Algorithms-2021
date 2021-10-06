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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append('<');
        for (int i = 0; i < denominations.length - 1; i++) {
            sb.append(denominations[i]);
            sb.append(',');
        }
        sb.append(denominations[denominations.length - 1]);
        sb.append('>');

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DenominationSet)) {
            return false;
        }

        DenominationSet ds = (DenominationSet) o;

        base: for (int i = 0; i < denominations.length; i++) {
            for (int j = 0; j < denominations.length; j++) {
                if (denominations[i] == ds.get(i)) {
                    continue base;
                }
            }
            return false;
        }

        return true;
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


    public static void main(String[] args) {
        int[] den1 = new int[]{1, 245, 2, 5};
        int[] den2 = new int[]{234, 1, 2, 9};
        int[] den3 = new int[]{1, 245, 2, 5};

        DenominationSet[] sets = new DenominationSet[]{new DenominationSet(den1), new DenominationSet(den2), new DenominationSet(den3)};

        // Print all
        for (DenominationSet set : sets) {
            System.out.println(set);
        }
        System.out.println();

        // Compare
        for (int i = 0; i < sets.length; i++) {
            for (int j = 0; j < sets.length; j++) {
                System.out.print(sets[i].toString() + " == " +sets[j].toString());
                System.out.println(" " + sets[i].equals(sets[j]));
            }
        }
    }
}
