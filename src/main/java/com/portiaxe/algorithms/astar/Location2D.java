package com.portiaxe.algorithms.astar;

public class Location2D {

    private int x;
    private int y;

    public Location2D() {}
    public Location2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String toString() {
        return "["+x+","+y+"]";
    }
}

