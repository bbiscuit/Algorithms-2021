package com.algorithms.rushhour;

public class Vehicle {
    private String vehicleType;
    private String color;
    private Orientation orientation;
    private int vehicleLength;
    private Coordinate[] fullVehicle;

    public Vehicle(String vehicleT, String colorStr, char orien, int x, int y){
        vehicleType = vehicleT;
        color = colorStr;
        fullVehicle = new Coordinate[3];
        vehicleLength = (vehicleType.equals("truck")) ? 3 : 2;

            // orientation = o;
        if (orien == 'h') {
            orientation = Orientation.Horizontal;
        }
        else {
            orientation = Orientation.Vertical;
        }

        // pivot point / point of interest
        fullVehicle[0] = new Coordinate(x,y);
        
        if (orien == 'h') {
            fullVehicle[1] = new Coordinate(x + 1, y);
            if (vehicleType.equals("truck")) {
                fullVehicle[2] = new Coordinate(x + 2, y);
            }
        }
        else {
            fullVehicle[1] = new Coordinate(x, y + 1);
            if (vehicleType.equals("truck")) {
                fullVehicle[2] = new Coordinate(x, y + 2);
            }
        }
    }

    public int getVehicleLen(){
        return vehicleLength;
    }

    public Coordinate getPart(int partNumber){
        if ((vehicleType.equals("car")) && (partNumber == 2))
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
        if (orientation == Orientation.Horizontal){
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
