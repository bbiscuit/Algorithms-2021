package com.algorithms.makingchange;

public class Recursive implements ChangeMaker {
    
    @Override
    public CoinPurse count(int value, DenominationSet set){
        CoinPurse result = RecursiveSearch(value, set);
        return result;
    }


    private CoinPurse RecursiveSearch(int value, DenominationSet set){
        if(value == 0){
            CoinPurse temp = new CoinPurse(set);
            return temp;
        }
        CoinPurse bestCP = null;
        int coinAdded = 0;
        for (int i = set.numDenominations()-1; i > 0; i--){
            int den = set.get(i);
            int nextValue = (value - den);
            CoinPurse currCP = new CoinPurse(set);
            if (nextValue > 0){
                 currCP = RecursiveSearch(nextValue, set);
            }
            if (bestCP == null) {
                bestCP = currCP;
                coinAdded = den;
            }
            if ((currCP.getNumCoins() < bestCP.getNumCoins()) || (bestCP.getNumCoins() == 0)) {
                bestCP = currCP;       
                coinAdded = den;     
            }
        }

        bestCP.addCoin(coinAdded);
        return bestCP;
    }
}

