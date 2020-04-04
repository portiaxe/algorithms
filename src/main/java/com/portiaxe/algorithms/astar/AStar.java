package com.portiaxe.algorithms.astar;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AStar {

    private Graph2D graph;

    public AStar(Graph2D graph) {
        this.graph = graph;
    }

    public List<Path> search(Path start, Path goal) {
        List<Path> openList = new ArrayList<>();
        List<Path> closedList = new ArrayList<>();
        List<Path> shortestPath = new ArrayList<>();

        openList.add(start);

        while(!openList.isEmpty()) {
            //find the lowest f(x) to process next
            Path currentPath = openList.stream().min(Comparator.comparing(Path::getF)).get();

            if(currentPath.equals(goal)) {
                Path curr = currentPath;
                while(curr.getParent() != null) {
                    shortestPath.add(curr);
                    curr = curr.getParent();
                }
                Collections.reverse(shortestPath);
                return shortestPath;

            }

            openList.remove(currentPath);
            closedList.add(currentPath);
            List<Path> adjacent = graph.getAdjacentPaths(currentPath);
            for(Path child: adjacent) {

                if(!child.isTraversible() || closedList.contains(child)) {
                    continue;
                }
                // this is the first time this path is explored it must be the best
                // set the heuristic score since it is not yet initialized
                if(!openList.contains(child)) {
                    child.g(currentPath.getG()+ 1) // distance child and  currentPath, 1 since not moving diagonally
                            .h(getDistanceBetweentPoints(child.getLocation(), goal.getLocation())) //distance from child to goal
                            .f(child.getG() + child.getH());

                    openList.add(child);
                    child.setParent(currentPath);
                }else {
                    Path bestCurrentPath = openList.stream().min(Comparator.comparing(Path::getG)).get();
                    // found the best path among encountered path
                    if(child.getG() <= bestCurrentPath.getG()) {
                        child.setParent(currentPath);
                    }
                }

            }
        }
        return shortestPath;
    }

    private double getDistanceBetweentPoints(@NotNull Location2D start, @NotNull Location2D end) {
        return Math.sqrt((end.getY() - start.getY()) * (end.getY() - start.getY()) + (end.getX() - start.getX()) * (end.getX() - start.getX()));
    }

}
