package com.algorithms.makingchange;

public class TestFile {
    public static void main(String[] args) {
        int[] denomSet = new int[]{1, 20};
        DenominationSet denom = new DenominationSet(denomSet);
        CoinPurse testR = null;
        ChangeMaker testRecurse = new Recursive();
        testR = testRecurse.count(44, denom);
        System.out.print("Number of Coins back: ");
        System.out.println(testR.getNumCoins());
        for (int i = 0; i < denom.numDenominations(); i++){
            if(testR.getNumCoins(denom.get(i)) != 0){
                System.out.print(denom.get(i));
                System.out.print(":");
                System.out.println(testR.getNumCoins(denom.get(i)));
            }
        }
    }
    
}
