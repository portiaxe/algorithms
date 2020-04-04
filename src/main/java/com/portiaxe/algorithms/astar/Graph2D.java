package com.portiaxe.algorithms.astar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph2D {
    Set<Path> paths;

    private int width;
    private int height;

    public Graph2D() {
        this.width = 4;
        this.height = 4;
        initGraph();
    }

    public Graph2D(int width, int height) {
        this.width = width;
        this.height = height;
    }


    private void initGraph() {
        this.paths = new HashSet<>();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                Path path = new Path(new Location2D(x,y));
                paths.add(path);
            }
        }
    }

    public Path getPath(int x, int y) {
        if(!paths.isEmpty() && paths != null) {
            return paths.stream().filter(path -> path.isSameLocation(x,y))
                    .findAny()
                    .orElse(null);
        }
        return null;
    }

    public List<Path> getAdjacentPaths(Path path){
        if(path != null && paths != null && !paths.isEmpty()) {
            int x = path.getLocation().getX();
            int y = path.getLocation().getY();
            return paths.stream()
                    .filter(
                            p -> (p.isSameLocation(x -1, y) ||
                                    p.isSameLocation(x , y - 1) ||
                                    p.isSameLocation(x , y + 1) ||
                                    p.isSameLocation(x + 1, y))
                    )
                    .collect(Collectors.toList());
        }
        return new ArrayList();
    }
    public List<Path> getAdjacentPaths(int x, int y){
        Path path = getPath(x,y);
        return getAdjacentPaths(path);
    }

    public void setTraversible(int x, int y, boolean traversible) {
        Path path = getPath(x,y);
        path.setTraversible(traversible);
    }
    public void printMap() {
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                Path path = getPath(x,y);
                String symbol = path.isTraversible() ? "[O]": "[X]";
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
