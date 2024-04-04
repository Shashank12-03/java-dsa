package graph;
import java.util.*;

public class leetcode805 {
    public static void main(String[] args) {
        
    }
    // List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
    //     int[] visited = new int[V];
    //     int[] pathVisited = new int[V];
    //     int[] checkNode = new int[V];

    //     for (int i = 0; i < V; i++) {
    //         if (visited[i]!=1) {
    //             dfs(i, adj, visited, pathVisited, checkNode);
    //         }
    //     }
    //     List<Integer> res = new ArrayList<>();
    //     for (int i = 0; i < V; i++) {
    //         if (checkNode[i]==1) {
    //             res.add(i);
    //         }
    //     }
    //     return res;
    // }
    // private boolean dfs(int node, List<List<Integer>> adj, int[] visited, int[] pathVisited, int[] checkNode) {
    //     visited[node] = 1;
    //     pathVisited[node] = 1;
    //     checkNode [node]= 0;
    //     for (int ind : adj.get(node)) {
    //         if (visited[ind]==0) {
    //             if(dfs(ind, adj, visited, pathVisited, checkNode) == true){
    //                 return true;
    //             }
    //         }
    //         // it the node has been previously visited but it has to visit on same path
    //         else{
    //             if (pathVisited[ind]==1) {
    //                 return true;
    //             }
    //         }
    //     }
    //     checkNode[node]=1;
    //     pathVisited[node]=0;
    //     return false;
    // }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        int[] checkNode = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i]!=1) {
                dfs(i, graph, visited, pathVisited, checkNode);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (checkNode[i]==1) {
                res.add(i);
            }
        }
        return res;
    }
    private boolean dfs(int node, int[][] adj, int[] visited, int[] pathVisited, int[] checkNode) {
        visited[node] = 1;
        pathVisited[node] = 1;
        checkNode [node]= 0;
        for (int ind : adj[node]) {
            if (visited[ind]==0) {
                if(dfs(ind, adj, visited, pathVisited, checkNode) == true){
                    return true;
                }
            }
            // it the node has been previously visited but it has to visit on same path
            else{
                if (pathVisited[ind]==1) {
                    return true;
                }
            }
        }
        checkNode[node]=1;
        pathVisited[node]=0;
        return false;
    }
}
