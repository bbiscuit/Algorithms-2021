package com.algorithms.galacticbreakup;

public class Monarchy {
    private Dominion matrix[][][];
    private int nMax,mMax,kMax;

    public Dominion[][][] buildGalaxy(int nlen, int mlen, int klen){
        nMax = nlen;
        mMax = mlen;
        kMax = klen;
        return matrix = new Dominion[nlen][mlen][klen];
    }

    // basically makeSet
    public void formDominionFromNothing(Dominion inputD, Coordinate nmkCoord){
        // I. We are going to start by creating the new dominion to the galaxy
        // II. We are going to add it to an empire if one exists
        //     a. Check the surrounding parsects for another dominion
        //     b. Set the new dominion to the current ruling dominion of the empire
        
        int n = nmkCoord.getN();
        int m = nmkCoord.getM();
        int k = nmkCoord.getK();

        // I. We are going to start by creating the new dominion to the galaxy
        matrix[n][m][k] = inputD;
        // II. We are going to add it to an empire if one exists
        //     a. Check the surrounding parsects for another dominion
        Coordinate[] possibleTargets = new Coordinate[6];
        possibleTargets = findTargets(possibleTargets, n, m, k);

        //     b. Set the new dominion to the current ruling dominion of the empire
        for (int i = 0; i < 6; i++){
            if (possibleTargets[i] != null){
                int tempN = possibleTargets[i].getN();
                int tempM = possibleTargets[i].getM();
                int tempK = possibleTargets[i].getK();
                unionEmpires(matrix[tempN][tempM][tempK], matrix[n][m][k]);
            }
        }

    }

    private void unionEmpires(Dominion A, Dominion B){
        Dominion rulerA = A.findKingdom();
        Dominion rulerB = B.findKingdom();

        if (rulerA.getServants() >= rulerB.getServants()){
            rulerB.setParent(rulerA);
        }
        else {
            rulerA.setParent(rulerB);
        }
    }

    private Coordinate[] findTargets(Coordinate[] coordTable, int n, int m, int k){
        // Setup a table of targets
        // [up (0), down, front, back, left, right(5)]
       
        // Checking above it
        if (k > kMax - 1){
            coordTable[0] = null;
        }
        else {
            coordTable[0] = new Coordinate(n, m, k + 1);
        }
        // Checking below it
        if (k < 0){
            coordTable[1] = null;
        }
        else {
            coordTable[1] = new Coordinate(n, m, k - 1);
        }

        // Checking front it
        if (m > mMax - 1){
            coordTable[2] = null;
        }
        else {
            coordTable[2] = new Coordinate(n, m, k + 1);
        }
        // Checking back it
        if (m < 0){
            coordTable[3] = null;
        }
        else {
            coordTable[3] = new Coordinate(n, m, k - 1);
        }

        // Checking right it
        if (n > nMax - 1){
            coordTable[4] = null;
        }
        else {
            coordTable[4] = new Coordinate(n, m, k + 1);
        }
        // Checking left it
        if (n < 0){
            coordTable[5] = null;
        }
        else {
            coordTable[5] = new Coordinate(n, m, k - 1);
        }

        return coordTable;
    }

    public Dominion secedeDominion(Dominion d){
        return d;
    }

}
