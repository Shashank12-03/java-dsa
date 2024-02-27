package dsa.graph;

import java.util.ArrayList;
import java.util.List;


public class dfs {
    public static void main(String[] args) {
        int numVertices = 9;
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
        boolean[] visited=new boolean[numVertices+1];
        System.out.println(DepthFirstSearch(visited, adjacencyList));
    }
    public static void addEdge(List<List<Integer>> adjacencyList, int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u); // For undirected graph
    }
    public static List<Integer> DepthFirstSearch(boolean[] visited,List<List<Integer>> adjacentList){
        List<Integer> dfs=new ArrayList<>();
        visited[0]=true;
        DFS(0,visited,adjacentList,dfs);
        return dfs;
        
    }
    private static void DFS(int node, boolean[] visited, List<List<Integer>> adjacentList, List<Integer> dfs) {
        visited[node]=true;
        dfs.add(node);
        for (Integer integer : adjacentList.get(node)) {
            if (!visited[integer]) {
                visited[integer]=true;
                DFS(integer, visited, adjacentList, dfs);
            }
        }
    }
}
