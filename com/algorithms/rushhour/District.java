package com.algorithms.rushhour;

public class District {
    private Coordinate[][] gameBoard;
    private int[][] displayBoard;
    private Vehicle goalVehicle;

    public District(){
        gameBoard = new Coordinate[6][6];
        // diplayBoard can be used for the algorithm to determine
        // if it has checked this iteration
        displayBoard = new int[6][6];
    }

    public void inputVehicle(Vehicle v, int inputNumber, Boolean isGoalVehicle){
        if (isGoalVehicle)
            goalVehicle = v;

        Coordinate[] tempV = v.getFullVehicle();

        for (int i = 0; i < v.getVehicleLen(); i++){
            int tempX = tempV[i].getX();
            int tempY = tempV[i].getY();
            gameBoard[tempX][tempY] = v.getPart(i);
            displayBoard[tempX][tempY] = inputNumber;
        }
    }

    public Vehicle getGoalVehicle(){
        return goalVehicle;
    }

    public Coordinate[][] getBoard(){
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
}
