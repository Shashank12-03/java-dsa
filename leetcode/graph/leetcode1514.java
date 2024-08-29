package graph;

import java.util.ArrayList;
// import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode1514 {
    public static void main(String[] args) {
        
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // List<List<Integer>> adj = new ArrayList<>();
        Map<Integer,List<Pair>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double pathProb = succProb[i];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, pathProb));
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, pathProb));
        }
        // for (int i = 0; i < n; i++) {
        //     adj.add(new ArrayList<>());
        // }

        // for (int i = 0; i < edges.length; i++) {
        //     adj.get(edges[i][0]).add(edges[i][1]);
        //     adj.get(edges[i][1]).add(edges[i][0]);
        // }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(a.succ,b.succ));
        pq.add(new Pair(start_node,1.0));
        double[] maxProb = new double[n];
        maxProb[start_node] = 1;
        while (!pq.isEmpty()) {
            int vertex = pq.peek().vertx;
            double succRate = pq.peek().succ;
            if(vertex == end_node){
                return succRate;
            }
            pq.remove();
            for (Pair nxt : adj.getOrDefault(vertex, new ArrayList<>())) {
                int node = nxt.vertx;
                double prob = nxt.succ;
                if(succRate*prob>maxProb[node]){
                    maxProb[node] =succRate*prob;
                    pq.add(new Pair(node,maxProb[node]));
                }
            }
        }
        return 0d;
    }
}
class Pair{
    int vertx;
    double succ;
    Pair(int vertx,double succ){
        this.vertx = vertx;
        this.succ = succ; 
    }
}