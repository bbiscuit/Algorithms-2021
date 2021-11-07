package com.algorithms.rushhour;

public class Vehicle {
    private String vehicleType;
    private String color;
    private Coordinate pivotPoint;
    private Coordinate vehicleMiddle;
    private Coordinate truckEnd;

    public Vehicle(String v, String c, char o, int x, int y){
        vehicleType = v;
        color = c;
        pivotPoint = new Coordinate(x,y);
        
        if (o == 'h')
            vehicleMiddle = new Coordinate(x + 1, y);
            if (vehicleType == "truck")
                truckEnd = new Coordinate(x + 2, y);
        else
            vehicleMiddle = new Coordinate(x, y + 1);
            if (vehicleType == "truck")
                truckEnd = new Coordinate(x, y + 2);
    }

    public Coordinate getPivotPoint(){
        return pivotPoint;
    }

    public Coordinate getVehicleMiddle(){
        return vehicleMiddle;
    }

    public Coordinate getTruckEnd(){
        if (vehicleType == "truck")
            return truckEnd;
        else 
            throw new InvalidVehicleTypeException("Vehicle type is not a truck");   
    }

    public String getColour(){
        return color;
    }
}
