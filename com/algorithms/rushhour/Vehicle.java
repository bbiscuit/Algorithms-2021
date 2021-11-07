package com.algorithms.rushhour;

public class Vehicle {
    private String vehicleType;
    private String color;
    private char orientation;
    private int vehicleLength;
    private Coordinate[] fullVehicle;

    public Vehicle(String v, String c, char o, int x, int y){
        vehicleType = v;
        color = c;
        fullVehicle = new Coordinate[3];
        vehicleLength = (vehicleType == "truck") ? 3 : 2;
        orientation = o;

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

    public Coordinate getPart(int partNumber){
        if ((vehicleType == "car") && (partNumber == 2))
            throw new InvalidVehicleTypeException("Vehicle type is not a truck");
        else 
            return fullVehicle[partNumber];
    }

    public String getColour(){
        return color;
    }

    public String getVehicleType(){
        return vehicleType;
    }

    public Coordinate[] getFullVehicle(){
        return fullVehicle;
    }

    // Amount should be parsed as Positive!
    public void moveVehicle(int amount, char dir){
        if (orientation == 'h'){
            switch(dir){
                case 'R': // Moving to the right will be moving in x
                    for (int i = 0; i < vehicleLength; i++){
                        fullVehicle[i].moveX(amount);
                    }
                    break;
                case 'L': // Moving to the left is -x
                    for (int i = 0; i < vehicleLength; i++){
                        fullVehicle[i].moveX(-amount);
                    }
                    break;
                default:
                    throw new InvalidMovementDirectionException("Vehicle in horizontal orientation, cannot move vertically!");
            }
        }
        else {
            switch(dir){
                case 'U': // Moving up is +y
                    for (int i = 0; i < vehicleLength; i++){
                        fullVehicle[i].moveY(amount);
                    }
                    break;
                case 'D': // Moving down is -y
                    for (int i = 0; i < vehicleLength; i++){
                        fullVehicle[i].moveY(-amount);
                    }
                    break;
                default:
                    throw new InvalidMovementDirectionException("Vehicle in vertical orientation, cannot move horizontally!");
            }
        }
    }
}
