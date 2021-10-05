package com.algorithms.makingchange;

public class TestFile {
    public static void main(String[] args) {
        DenominationSet denom = new DenominationSet();
        CoinPurse testR = null;
        ChangeMaker testRecurse = new Recursive();
        testR = testRecurse.count(26, denom);
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
