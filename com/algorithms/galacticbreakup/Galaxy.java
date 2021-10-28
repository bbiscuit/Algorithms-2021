package com.algorithms.galacticbreakup;

import java.util.ArrayList;

public class Galaxy {
    private Dominion matrix[][][];
    private int nMax,mMax,kMax, monthsSeparated;
    private ArrayList<Dominion> list = new ArrayList<>();

    Galaxy(int nlen, int mlen, int klen) {
        nMax = nlen;
        mMax = mlen;
        kMax = klen;
        matrix = new Dominion[nlen][mlen][klen];
    }

    // Basically just makeSet
    public void formDominionExNihilo(Dominion inputD) {
        // I. We are going to start by creating the new dominion to the galaxy
        // II. We are going to add it to an empire if one exists
        //     a. Check the surrounding parsects for another dominion
        //     b. Set the new dominion to the current ruling dominion of the empire
        Coordinate nmkCoord = inputD.getNMK();

        int n = nmkCoord.getN();
        int m = nmkCoord.getM();
        int k = nmkCoord.getK();

        // I. We are going to start by creating the new dominion to the galaxy
        matrix[n][m][k] = inputD;
        // II. We are going to add it to an empire if one exists
        //     a. Check the surrounding parsects for another dominion
        Coordinate[] possibleTargets = new Coordinate[6];
        possibleTargets = findTargets(possibleTargets, nmkCoord);

        //     b. Set the new dominion to the current ruling dominion of the empire
        for (int i = 0; i < 6; i++){
            if (possibleTargets[i] != null){
                int tempN = possibleTargets[i].getN();
                int tempM = possibleTargets[i].getM();
                int tempK = possibleTargets[i].getK();
                unionEmpires(matrix[tempN][tempM][tempK], matrix[n][m][k]);
            }
        }

        // Add back the full size kingdoms
        list.add(inputD.findKingdom());
        checkSeparation();
    }

    // Basically just union
    private void unionEmpires(Dominion A, Dominion B) {
        Dominion rulerA = A.findKingdom();
        Dominion rulerB = B.findKingdom();

        if (rulerA != rulerB) {

            // Remove both of the dominions from the array list while we merge them
            // We end up adding the dominions back after the input has been added
            for(int i = 0; i < list.size() - 1; i++){
                if ((list.get(i) == rulerA) || (list.get(i) == rulerB) ){
                    list.remove(i);
                }
            }

            if (rulerA.getServants() >= rulerB.getServants()){
                rulerB.setParent(rulerA);
                rulerA.incrementServants(rulerB.getServants());
            }
            else {
                rulerA.setParent(rulerB);
                rulerB.incrementServants(rulerA.getServants());
            }
        }
    }

    // Builds adjacency matrix
    private Coordinate[] findTargets(Coordinate[] coordTable, Coordinate dCoord) {
        // Setup a table of targets
        // [up (0), down, front, back, left, right(5)]
        int n = dCoord.getN();
        int m = dCoord.getM();
        int k = dCoord.getK();

        // Checking above it
        if (k >= kMax - 1){
            coordTable[0] = null;
        }
        else {
            if (matrix[n][m][k+1] != null)
                coordTable[0] = new Coordinate(n, m, k + 1);
        }
        // Checking below it
        if (k <= 0){
            coordTable[1] = null;
        }
        else {
            if (matrix[n][m][k-1] != null)
                coordTable[1] = new Coordinate(n, m, k - 1);
        }

        // Checking front it
        if (m >= mMax - 1){
            coordTable[2] = null;
        }
        else {
            if (matrix[n][m + 1][k] != null)
                coordTable[2] = new Coordinate(n, m + 1, k);
        }
        // Checking back it
        if (m <= 0){
            coordTable[3] = null;
        }
        else {
            if (matrix[n][m - 1][k] != null)
                coordTable[3] = new Coordinate(n, m - 1, k);
        }

        // Checking right it
        if (n >= nMax - 1){
            coordTable[4] = null;
        }
        else {
            if (matrix[n + 1][m][k] != null)
                coordTable[4] = new Coordinate(n + 1, m, k);
        }
        // Checking left it
        if (n <= 0){
            coordTable[5] = null;
        }
        else {
            if (matrix[n - 1][m][k] != null)
                coordTable[5] = new Coordinate(n - 1, m, k);
        }

        return coordTable;
    }



    private void checkSeparation() {
        if (list.size() > 1){
            monthsSeparated += 1;
        }
    }

    public int getMonthSeparated() {
        return monthsSeparated;
    }
}
