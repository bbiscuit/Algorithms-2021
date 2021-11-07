package com.algorithms.rushhour;

import java.util.ArrayList;


public class District {
    private Vehicle[][] gameBoard;
    private int[][] displayBoard;
    private Vehicle goalVehicle;
    private ArrayList<Vehicle> allVehicles;

    public District(){
        gameBoard = new Vehicle[6][6];
        // diplayBoard can be used for the algorithm to determine
        // if it has checked this iteration
        displayBoard = new int[6][6];
    }

    public void inputVehicle(Vehicle v){
        allVehicles.add(v);

        if (v.getColour().equals("red"))
            goalVehicle = v;

        Coordinate tempCoordinate = v.getSource();

        for (int i = 0; i < v.getVehicleLen(); i++){
            int tempX = tempCoordinate.getX();
            int tempY = tempCoordinate.getY();
            if (v.getOrientation() == Orientation.Horizontal){
                gameBoard[tempX + i][tempY] = v;
                displayBoard[tempX + i][tempY] = allVehicles.size();
            }
            else {
                gameBoard[tempX][tempY + i] = v;
                displayBoard[tempX][tempY + i] = allVehicles.size();
            }
            
        }
    }

    public Vehicle getGoalVehicle(){
        return goalVehicle;
    }

    public Vehicle[][] getBoard(){

        return gameBoard;
    }

    public int[][] getDisplay(){
        return displayBoard;
    }

    /**
     * toString override of type District.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                sb.append(displayBoard[i][j]);
            }
        }
        return sb.toString();
    }
}
