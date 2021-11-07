package com.algorithms.rushhour;

public class Vehicle {
    private String vehicleType;
    private String color;
    private char orientation;
    private Coordinate pivotPoint;

    public Vehicle(String v, String c, char o, int x, int y){
        vehicleType = v;
        color = c;
        orientation = o;
        pivotPoint = new Coordinate(x,y);
        // may want to do some type checking as a car and
        // a truck have defined lengths
    }

    
}
