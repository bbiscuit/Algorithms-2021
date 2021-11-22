package com.algorithms.roadscholar;

public class Tuple<T1, T2> {
    private T1 key;
    private T2 val;

    public Tuple(T1 key, T2 val) {
        this.key = key;
        this.val = val;
    }

    public T1 getKey() {
        return key;
    }

    public T2 getVal() {
        return val;
    }
}
