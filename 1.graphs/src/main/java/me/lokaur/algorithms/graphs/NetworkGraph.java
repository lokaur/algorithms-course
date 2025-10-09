package me.lokaur.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkGraph {

    private final Map<String, List<NetworkEdge>> map;

    public NetworkGraph() {
        map = new HashMap<>();
    }

    public void addNode(String name) {
        map.putIfAbsent(name, new ArrayList<>());
    }

    public void addEdge(String from, String to, int bandwidth, int packetLossPercentage) {
        if (!map.containsKey(from)) {
            addNode(from);
        }
        if (!map.containsKey(to)) {
            addNode(to);
        }
        var fromEdges = map.get(from);
        fromEdges.add(new NetworkEdge(to, bandwidth, packetLossPercentage));

        var toEdges = map.get(to);
        toEdges.add(new NetworkEdge(from, bandwidth, packetLossPercentage));
    }

    public void print() {
        map.forEach((name, edges) -> {
            System.out.printf("%s -> ", name);
            if (edges.isEmpty()) {
                System.out.println("none");
                return;
            }
            edges.forEach(edge -> System.out.printf("%s(%d %d%%), ", edge.to, edge.bandwidth, edge.packetLossPercentage));
            System.out.println();
        });
    }
}
