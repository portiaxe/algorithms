package com.portiaxe.algorithms.astar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph2D graph = new Graph2D();
        AStar aStar = new AStar(graph);
        boolean traversible = false;
        graph.setTraversible(1, 0, traversible);
        graph.setTraversible(1, 2, traversible);
        graph.setTraversible(1, 3, traversible);


        graph.printMap();
        Path start = graph.getPath(0, 0);
        Path goal = graph.getPath(3,3);
        List<Path> shortestPath = aStar.search(start, goal);
        for(Path p: shortestPath) {
            System.out.println(p.getLocation());
        }
    }
}
