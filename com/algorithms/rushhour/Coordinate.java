package com.algorithms.rushhour;

/**
 * A simple coordinate in a two-dimensional array.
 * @author Andrew Huffman, Kyle Samuelson
 */
public class Coordinate {
    private int x;
    private int y;

    /**
     * Constructor.
     * @param x The x-component of the coordinate.
     * @param y The y-component of the coordinate.
     */
    public Coordinate(int n, int m) {
        this.x = n;
        this.y = m;
    }

    /**
     * Gets the x-component of the coordinate.
     * @return The x-component.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-component of the coordinate.
     * @return The y-component.
     */
    public int getY() {
        return y;
    }

    public void moveX(int v){
        x += v;
    }

    public void moveY(int v){
        y += v;
    }

    /**
     * toString override of type Coordinate.
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
