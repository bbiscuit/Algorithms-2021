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

    public void inputVehicle(Vehicle v, int inputNumber){
        allVehicles.add(v);

        if (v.getColour().equals("red"))
            goalVehicle = v;

        Coordinate tempCoordinate = v.getSource();

        for (int i = 0; i < v.getVehicleLen(); i++){
            int tempX = tempCoordinate.getX();
            int tempY = tempCoordinate.getY();
            if (v.getOrientation() == Orientation.Horizontal){
                gameBoard[tempX + i][tempY] = v;
            }
            else {
                gameBoard[tempX][tempY + i] = v;
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
                sb.append(displayBoard[i][j] + " ");
            }
        }
        return sb.toString();
    }

    private bool containsVehicle(int x, int y) {
        return gameBoard[x][y] != null;
    }

    private bool outOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= displayBoard.length || y >= displayBoard[x].length;
    }

    private bool validMove(Vehicle v, int val) {
        // I. Check the validity of the move, and if the vehicle is in play.
        // II. If the vehicle is horizontal...
            // A. If we're moving left...
                // 1. We begin movement from the source and iterate backwards
                // until we reach newLoc.
                // 2. If there is a car in the way, or the newLoc is invalid,
                // return false.
            // B. If we're moving right...
                // 1. We begin movment at the end of the vehicle and iterate
                // forwards until we reach newLoc + vehicleLength - 1.
                // 2. If there is a car in the way, or newLoc is invalid,
                // return false.
        // III. If the vehicle is vertical...
            // A. If we're moving up...
                // 1. We begin movement from the source and iterate backwards
                // until we reach newLoc.
                // 2. If there is a car in the way, or the newLoc is invalid,
                // return false.
            // B. If we're moving down...
                // 1. We begin movment at the end of the vehicle and iterate
                // forwards until we reach newLoc + vehicleLength - 1.
                // 2. If there is a car in the way, or newLoc is invalid,
                // return false.

        
        // I. Check the validity of the move, and if the vehicle is in play.
        if (val == 0) {
            return false;
        }
        else if (!allVehicles.contains(v)) {
            return false;
        }

        Coordinate sourceCoord = v.getSource();


        // II. If the vehicle is horizontal...
        if (v.getOrientation() == Orientation.Horizontal) {
            int newLoc = sourceCoord.getX() + val;
            int i;
            int modulus;
            
            // A. If we're moving left...
                
            if (val < 0) {
                // 1. We begin movement from the source and iterate backwards
                // until we reach newLoc.
                // 2. If there is a car in the way, or the newLoc is invalid,
                // return false.

                i = sourceCoord.getX();
                modulus = -1;
                newLoc = sourceCoord.getX() + val;
            }

            // B. If we're moving right...

            else {
                // 1. We begin movment at the end of the vehicle and iterate
                // forwards until we reach newLoc + vehicleLength - 1.
                // 2. If there is a car in the way, or newLoc is invalid,
                // return false.

                i = sourceCoord.getX() + v.getVehicleLen() - 1;
                modulus = 1;
                newLoc = sourceCoord.getX() + val + v.getVehicleLen() - 1;
            }

            if (outOfRange(newLoc, sourceCoord.getY())) {
                return false;
            }
                        
            while (i != newLoc) {
                i += modulus;

                if (containsVehicle(i, sourceCoord.getX())) {
                    return false;
                }
            }
        }

        // III. If the vehicle is vertical...

        else {
            

            int newLoc = sourceCoord().getY() + val;
            int i;
            int modulus;

            // A. If we're moving up...
            
            if (val < 0) {
                // 1. We begin movement from the source and iterate backwards
                // until we reach newLoc.
                // 2. If there is a car in the way, or the newLoc is invalid,
                // return false.

                i = sourceCoord.getY();
                modulus = -1;
                newLoc = soruceCoord().getY() + val;
            }

            // B. If we're moving down...
            
            else {
                // 1. We begin movment at the end of the vehicle and iterate
                // forwards until we reach newLoc + vehicleLength - 1.
                // 2. If there is a car in the way, or newLoc is invalid,
                // return false.

                i = sourceCoord.getY() + v.getVehicleLen() - 1;
                modulus = 1;
                newLoc = sourceCoord.getY() + val + v.getVehicleLen() - 1;
            }

            if (outOfRange(sourceCoord.getX(), newLoc)) {
                return false;
            }
                        
            while (i != newLoc) {
                i += modulus;

                if (containsVehicle(sourceCoord.getX(), newLoc)) {
                    return false;
                }
            }
        }

        return true;
    }

    public Vehicle[][][] allPossibleMoves(Vehicle v) {
        // I. Check if the vehicle is in play.
        // II. Build all permutations of one-turn movement for the given vehicle.
        // III. Return the permutations.

        // I. Check if the vehicle is in play.

        if (v == null) {
            throw new InvalidVehicleException("Vehicle 'v' was null");
        }
        else if (!allVehicles.contains(v)) {
            throw new InvalidVehicleException("Vehicle 'v' was not in play");
        }

        // II. Build all permutations of one-turn movement for the given vehicle.

        Coordinate sourceCoord = v.getSource();



        // III. Return the permutations.

        return null;
    }
}
