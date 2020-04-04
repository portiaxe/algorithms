package com.portiaxe.algorithms.astar;

public class Path {
    private double f;
    private double g;
    private double h;
    private boolean traversible;
    private Location2D location;
    private Path parent;


    public Path getParent() {
        return parent;
    }
    public void setParent(Path parent) {
        this.parent = parent;
    }
    public Path() {
        this.location = new Location2D();
        this.traversible = true;
    }
    public Path(Location2D loc) {
        this.location = loc;
        this.traversible = true;
    }
    public Path location(Location2D loc) {
        this.location = loc;
        return this;
    }

    public Path f(double f) {
        this.f = f;
        return this;
    }
    public Path g(double g) {
        this.g = g;
        return this;
    }
    public Path h(double h) {
        this.h =h;
        return this;
    }

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }
    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
    public Location2D getLocation() {
        return location;
    }
    public void setLocation(Location2D location) {
        this.location = location;
    }

    public boolean isSameLocation(int x, int y) {
        return location.getX() == x && location.getY() == y;
    }
    public boolean isSameLocation(Location2D location) {
        return isSameLocation(location.getX(), location.getY());
    }
    public boolean isTraversible() {
        return traversible;
    }
    public void setTraversible(boolean traversible) {
        this.traversible = traversible;
    }
    public String getCoordinates() {
        return "{"+location.getX()+","+location.getY() +","+ (traversible ? "O" : "X")+"}";
    }

}
