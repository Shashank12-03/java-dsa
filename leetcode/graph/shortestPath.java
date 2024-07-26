package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class shortestPath {

    static class Pair{
        int vertx;
        int weight;
        Pair(int vertx,int weight){
            this.vertx = vertx;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestpath(new int[][]{{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}}, 9, 10, 0)));
        System.out.println(Arrays.toString(shortestpath(6, 7, new int[][]{{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}})));
    }
    public static int[] shortestpath(int N,int M, int[][] edges) {
		//Code here
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }

        int[] distance = new int[N];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        queue.add(new Pair(0, 0));
        //         0
        //       /   \
        //     2/     \1
        //     /       \
        //    1         2
        while (!queue.isEmpty()) {
            int node = queue.peek().vertx;
            int dist = queue.peek().weight;
            queue.poll();
            for (Pair edge : graph.get(node)) {
                int vertex = edge.vertx;
                int newDist = dist + edge.weight;
                if (newDist < distance[vertex]) {
                    distance[vertex] = newDist;
                    queue.add(new Pair(vertex, newDist));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (distance[i]==Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }
        return distance;
	}

    public static int[] shortestpath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int[] distance = new int[n];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        

        while (!queue.isEmpty()) {
            int node = queue.peek();
            queue.remove();
            for (int edge : graph.get(node)) {
                if (distance[node]+1<distance[edge]){
                    distance[edge] = distance[node] +1;
                    queue.add(edge);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (distance[i]==Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }
        return distance;
    }
}
