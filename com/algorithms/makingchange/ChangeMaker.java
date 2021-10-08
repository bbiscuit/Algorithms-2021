package com.algorithms.makingchange;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Base class for all types of change making dynamic-programming algorithms.
 * 
 * @author Andrew Huffman
 * @author Kyle Samuelson
 */
public interface ChangeMaker {
    
    public abstract CoinPurse count(int value, DenominationSet set);

    public static void main(String[] args) {
        // Test the different methods.
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter the denomination set to test with (space delim): ");
        String inString = input.nextLine();
        Scanner strScanner = new Scanner(inString);
        while (strScanner.hasNextInt()) {
            list.add(strScanner.nextInt());
        }
        strScanner.close();
        for (int i = 0; i < list.size(); i++) {
            
        }
    }
}
