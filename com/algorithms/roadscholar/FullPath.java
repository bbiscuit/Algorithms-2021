package com.algorithms.roadscholar;

public class FullPath {
    int dist;
    Node start;
    Node end;

    public FullPath(Node a, Node b){
        dist = 10000000;
        start = a;
        end = b;
    }

     public int getDist(){
        return dist;
    }

    public Node getStart(){
        return start;
    }

    public Node getEnd(){
        return end;
    }

    public void setDist(int d){
        dist = d;
    }
}
