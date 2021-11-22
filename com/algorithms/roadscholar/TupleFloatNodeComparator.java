package com.algorithms.roadscholar;

import java.util.Comparator;

public class TupleFloatNodeComparator implements Comparator<Tuple<Float, Node>> {
    public int compare(Tuple<Float, Node> a, Tuple<Float, Node> b) {
        float aV = a.getKey().floatValue();
        float bV = b.getKey().floatValue();

        if (aV < bV) {
            return -1;
        }   
        else if (aV > bV) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
