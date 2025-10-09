package me.lokaur.algorithms.graphs;

public class Main {
    public static void main(String[] args) {
        nodeBasedRepresentation();
    }

    private static void nodeBasedRepresentation() {
        var graph = new NetworkGraph();
        graph.addEdge("A", "B", 1500, 90);
        graph.addEdge("A", "C", 2000, 10);
        graph.addEdge("A", "D", 1000, 50);

        graph.addEdge("B", "F", 1500, 60);

        graph.addEdge("C", "F", 500, 20);
        graph.addEdge("C", "E", 900, 5);

        graph.addEdge("D", "E", 2500, 1);

        graph.addEdge("E", "F", 300, 85);

        graph.print();
    }
}