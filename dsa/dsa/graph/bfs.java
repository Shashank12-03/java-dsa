package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bfs {
    public static void main(String[] args) {
        int numVertices = 9; // Number of vertices in the graph

        // Create adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Add edges to the graph (undirected graph)
        addEdge(adjacencyList, 0, 1);
        addEdge(adjacencyList, 0, 2);
        addEdge(adjacencyList, 1, 3);
        addEdge(adjacencyList, 1, 4);
        addEdge(adjacencyList, 2, 4);
        addEdge(adjacencyList, 2, 5);
        addEdge(adjacencyList, 3, 6);
        addEdge(adjacencyList, 4, 7);
        addEdge(adjacencyList, 5, 8);
        boolean[] visited=new boolean[numVertices];
        System.out.println(breadthForSearch(visited, adjacencyList));
    }

    public static void addEdge(List<List<Integer>> adjacencyList, int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u); // For undirected graph
    }
    public static List<Integer> breadthForSearch(boolean[] visited,List<List<Integer>> adjacentList){
        List<Integer> bfs=new ArrayList<>();
        Queue<Integer> store=new LinkedList<>();
        store.add(0);
        visited[0]=true;
        while (!store.isEmpty()) {
            int num=store.poll();
            bfs.add(num);
            for (Integer integer : adjacentList.get(num)) {
                if (!visited[integer]) {
                    visited[integer]=true;
                    store.add(integer);
                }
            }
        }
        return bfs;
    }
}
