package com.algorithms.galacticbreakup;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();
        System.out.println();

        for (int i = 0; i < n * m * k; i++) {
            //System.out.println(Dominion.getNMK(i, n, m, k));
        }
        s.close();
    }
}
