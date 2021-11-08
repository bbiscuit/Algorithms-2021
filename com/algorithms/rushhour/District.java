package com.algorithms.rushhour;

import java.util.ArrayList;


public class District {
    private Vehicle[][] gameBoard;
    private Vehicle goalVehicle;
    private ArrayList<Vehicle> allVehicles;

    public District(){
        gameBoard = new Vehicle[6][6];
        // diplayBoard can be used for the algorithm to determine
        // if it has checked this iteration
        allVehicles = new ArrayList<Vehicle>();
    }

    public Object clone() {
        District result = new District();

        for (int i = 0; i < allVehicles.size(); i++) {
            result.inputVehicle((Vehicle)allVehicles.get(i).clone());
        }

        return result;
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
            }
            else {
                gameBoard[tempX][tempY + i] = v;
            }
            
        }
    }


    public static void main(String[] args) {
        District Nine = new District();

        Vehicle gameWinner = new Vehicle("car", "red", 'h', 3, 2);
        Vehicle randomTruck = new Vehicle("truck", "purple", 'v', 0, 1);
        Nine.inputVehicle(gameWinner);
        Nine.inputVehicle(randomTruck);

        System.out.println(Nine.toString());
        System.out.println();
        
        System.out.println("VALID MOVES 4 GAMEWINNER ;):");
        for (int i = -6; i <= 6; i++) {
            if (Nine.validMove(randomTruck, i)) {
                District x = Nine.move(randomTruck, i);
                System.out.println(i + ": ");
                System.out.println(x);
                System.out.println();
            }
        }
        
    }

    public Vehicle getGoalVehicle(){
        return goalVehicle;
    }

    public Vehicle[][] getBoard(){

        return gameBoard;
    }

    /**
     * toString override of type District.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[j][i] == null) {
                    sb.append(0);
                }
                else {
                    sb.append(allVehicles.indexOf(gameBoard[j][i]) + 1);
                }
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    private boolean containsVehicle(int x, int y) {
        return gameBoard[x][y] != null;
    }

    private boolean outOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= gameBoard.length || y >= gameBoard[x].length;
    }

    private boolean validMove(Vehicle v, int val) {
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
            

            int newLoc = sourceCoord.getY() + val;
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
                newLoc = sourceCoord.getY() + val;
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

    private District move(Vehicle v, int val) {
        if (validMove(v, val)) {
            Coordinate source = v.getSource();
            Vehicle[][] newBoard;

            int xLoc;
            int yLoc;

            // Copy the board
            District newDistrict = (District)clone();
            newBoard = newDistrict.getBoard();
            v = newBoard[source.getX()][source.getY()];

            // Null out original pos
            int x = source.getX();
            int y = source.getY();
            int xInc = 0;
            int yInc = 0;


            if (v.getOrientation() == Orientation.Horizontal) {
                xInc = 1;
                xLoc = x + val;
                yLoc = y;
            }
            else {
                yInc = 1;
                xLoc = x;
                yLoc = y + val;
            }

            for (int i = 0; i < v.getVehicleLen(); i++) {
                newBoard[x][y] = null;
                
                x += xInc;
                y += yInc;
            }

            // Place the car at the new loc
            v.setSource(xLoc, yLoc);

            for (int i = 0; i < v.getVehicleLen(); i++) {
                newBoard[xLoc][yLoc] = v;
                xLoc += xInc;
                yLoc += yInc;
            }

            return newDistrict;

        }
        else {
            return null;
        }
    }

    private ArrayList<Vehicle[][]> allPossibleMoves(Vehicle v) {
        // I. Check if the vehicle is in play.
        // II. Build all permutations of one-turn movement for the given vehicle.
        // III. Return the permutations.

        ArrayList<Vehicle[][]> result = new ArrayList<>();

        // I. Check if the vehicle is in play.

        if (v == null) {
            throw new InvalidVehicleException("Vehicle 'v' was null");
        }
        else if (!allVehicles.contains(v)) {
            throw new InvalidVehicleException("Vehicle 'v' was not in play");
        }

        // II. Build all permutations of one-turn movement for the given vehicle.

        int coord;
        if (v.getOrientation() == Orientation.Vertical) {
            coord = v.getSource().getY();
        }
        else {
            coord = v.getSource().getX();
        }

        // (Check all possible move locations for validity)
        for (int i = -4; i <= 4; i++) {
            if (validMove(v, i)) {
                
            }
        }



        // III. Return the permutations.

        return result;
    }
}
