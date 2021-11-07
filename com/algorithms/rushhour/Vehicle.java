package com.algorithms.rushhour;

public class Vehicle {
    private String vehicleType;
    private String color;
    private int vehicleLength;
    private Coordinate[] fullVehicle;

    public Vehicle(String v, String c, char o, int x, int y){
        vehicleType = v;
        color = c;
        fullVehicle = new Coordinate[3];
        vehicleLength = (vehicleType == "truck") ? 3 : 2;

        // pivot point / point of interest
        fullVehicle[0] = new Coordinate(x,y);
        
        if (o == 'h')
            fullVehicle[1] = new Coordinate(x + 1, y);
            if (vehicleType == "truck")
                fullVehicle[2] = new Coordinate(x + 2, y);
        else
            fullVehicle[1] = new Coordinate(x, y + 1);
            if (vehicleType == "truck")
                fullVehicle[2] = new Coordinate(x, y + 2);
    }

    public int getVehicleLen(){
        return vehicleLength;
    }

    public Coordinate getPivotPoint(){
        return fullVehicle[0];
    }

    public Coordinate getVehicleMiddle(){
        return fullVehicle[1];
    }

    public Coordinate getTruckEnd(){
        if (vehicleType == "truck")
            return fullVehicle[2];
        else 
            throw new InvalidVehicleTypeException("Vehicle type is not a truck");   
    }

    public String getColour(){
        return color;
    }

    public String getVehicleType(){
        return vehicleType;
    }

    public Coordinate[] getVehicleLoc(){
        return fullVehicle;
    }
}
