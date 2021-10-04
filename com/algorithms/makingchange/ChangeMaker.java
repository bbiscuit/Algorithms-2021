package com.algorithms.makingchange;

/**
 * Base class for all types of change making dynamic-programming algorithms.
 * 
 * @author Andrew Huffman
 * @author Kyle Samuelson
 */
public interface ChangeMaker {
    
    public abstract CoinPurse count(int value, DenominationSet set);

}
