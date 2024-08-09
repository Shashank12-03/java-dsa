package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// import Trees.leetcode987

public class leetcode787 {
    public static void main(String[] args) {
        leetcode787 sol = new leetcode787();
        System.out.println(sol.findCheapestPrice(5, new int[][] { { 1, 2, 10 }, { 2, 0, 7 }, { 1, 3, 8 }, { 4, 0, 10 },
                { 3, 4, 2 }, { 4, 2, 10 }, { 0, 3, 3 }, { 3, 1, 6 }, { 2, 4, 5 } }, 0, 4, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        int[] distance = new int[n];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));
        while (!queue.isEmpty()) {
            int stop = queue.peek().stop;
            int dest = queue.peek().dest;
            int cost = queue.peek().cost;
            queue.remove();
            if (stop > k) {
                continue;
            }
            for (Pair pair : adj.get(dest)) {
                int cst = pair.cost;
                int node = pair.dest;
                if (cost + cst < distance[node] && stop <= k) {
                    distance[node] = cost + cst;
                    queue.add(new Tuple(stop + 1, node, distance[node]));
                }
            }
        }
        
        return distance[dst]==Integer.MAX_VALUE?-1:distance[dst];
    }
}

class Pair {
    int dest;
    int cost;

    Pair(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}

class Tuple {
    int stop;
    int dest;
    int cost;

    Tuple(int stop, int dest, int cost) {
        this.stop = stop;
        this.dest = dest;
        this.cost = cost;
    }
}