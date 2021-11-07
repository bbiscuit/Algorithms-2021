package com.algorithms.rushhour;

public class Vehicle {
    private int vehicleLength;
    private String color;
    private Orientation orientation;
    private Coordinate source;

    /**
     * Constructor.
     * @param vehicleType The type of vehicle (car or truck) that this instance
     * is to be.
     * @param colorStr The color of the vehicle (string).
     * @param orien The orientation of the vehicle ('h' or 'v')
     * @param x The x-coordinate of the vehicle's pivot point.
     * @param y The y-coordinate of the vehicle's pivot point.
     */
    public Vehicle(String vehicleType, String colorStr, char orien, int x, int y){
        color = colorStr;
        vehicleLength = (vehicleType.equals("truck")) ? 3 : 2;
        
        // # Parse Orientation
        if (orien == 'h') {
            orientation = Orientation.Horizontal;
        }
        else if (orien == 'v') {
            orientation = Orientation.Vertical;
        }
        else {
            throw new InvalidVehicleException("vehicle can either be vertical or horizontal.");
        }

        source = new Coordinate(x, y);
    }

    /**
     * Gets the length of the vehicle.
     * @return The vehicle length.
     */
    public int getVehicleLen(){
        return vehicleLength;
    }

    /**
     * Gets the color of the vehicle.
     * @return The vehicle colour.
     */
    public String getColour(){
        return color;
    }

    /**
     * Gets the orientation of the vehicle (vertical or horizontal).
     * @return The orientation.
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Gets the "source" (leftmost for horizontals, bottommost for verticals) of
     * the vehicle.
     * @return The source.
     */
    public Coordinate getSource() {
        return source;
    }
}
