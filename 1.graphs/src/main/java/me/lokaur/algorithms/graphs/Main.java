package me.lokaur.algorithms.graphs;

public class Main {
    public static void main(String[] args) {
        nodeBasedRepresentation();
        matrixBasedRepresentation();
    }

    private static void matrixBasedRepresentation() {
        int[][] bandwidthMatrix = {
                {0, 1500, 2000, 1000, 0, 0}, // A
                {1500, 0, 0, 0, 0, 1500}, // B
                {2000, 0, 0, 0, 900, 500}, // C
                {1000, 0, 0, 0, 2500, 0}, // D
                {0, 0, 900, 2500, 0, 300}, // E
                {0, 1500, 500, 0, 300, 0} // F
                // A, B, C, D, E, F
        };
        int[][] packetLossMatrix = {
                {0, 90, 10, 50, 0, 0}, // A
                {90, 0, 0, 0, 0, 60}, // B
                {10, 0, 0, 0, 5, 20}, // C
                {50, 0, 0, 0, 1, 0}, // D
                {0, 0, 5, 1, 0, 85}, // E
                {0, 60, 20, 0, 85, 0} // F
                // A, B, C, D, E, F
        };

        System.out.println("Bandwidth matrix:");
        print(bandwidthMatrix);
        System.out.println("Packet loss matrix:");
        print(packetLossMatrix);
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.printf("%5d", col);
            }
            System.out.println();
        }
        System.out.println();
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

        System.out.println("Graph representation:");
        graph.print();
        System.out.println();
    }
}