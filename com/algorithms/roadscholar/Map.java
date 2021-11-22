package com.algorithms.roadscholar;

import java.util.ArrayList;

/**
* A map in the road-scholar problem.
* @author Kyle Samuelson
*/
public class Map {
    private ArrayList<Node> Atlas;
    private ArrayList<Node> Cities;
    private ArrayList<FullPath> foundPaths;

    public Map(){
        // Construct a new atlas
        Atlas = new ArrayList<Node>();
        Cities = new ArrayList<Node>();
    }

    public void addNode(Node n){
        // Adds a node to the atlas
        Atlas.add(n);
        // Adds a node to the City
        if (n.containsCity()){
            Cities.add(n);
        }
    }

    private ArrayList<FullPath> computeAllPair(){
        //
        //  Returns a FullPath with the all pairs shortest path
        //  a fullpath contains start and end nodes as well as dist
        //
        int n = Atlas.size();
        FullPath bestUV = null;
        
        for (int k = 0; k < n; k++){
            for (int u = 0; u < n; u++){
                for (int v = 0; v < n; v++){
                    FullPath bestUK = best(Atlas.get(u), Atlas.get(k));
                    FullPath bestKV = best(Atlas.get(k), Atlas.get(v));

                    if (bestUV == null){
                        bestUV = new FullPath(bestUK.getStart(), bestKV.getEnd());
                        bestUV.setDist(bestUK.getDist() + bestKV.getDist());
                    }
                    else if ((bestUK.getDist() + bestKV.getDist()) < bestUV.getDist()){
                        bestUV = new FullPath(bestUK.getStart(), bestKV.getEnd());
                        bestUV.setDist(bestUK.getDist() + bestKV.getDist());
                    }
                }
            }
        }
    }
            //// BEST IS THE MATRIX OF PREV
    private FullPath best(int a, int b){
        // I. Check if 
        for (int i = 0; i < a; i++){
            if
        }
    }


}
