package me.lokaur.algorithms.graphs;

public class NetworkEdge {
    final String to;
    final int bandwidth;
    final int packetLossPercentage;

    public NetworkEdge(String to, int bandwidth, int packetLossPercentage) {
        this.to = to;
        this.bandwidth = bandwidth;
        this.packetLossPercentage = packetLossPercentage;
    }
}
