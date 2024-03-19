package graph;

import java.util.ArrayList;

public class detectCycleDirectedGraph {
    public static void main(String[] args) {
        
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i]==0) {
                if (dfs(i,visited,pathVisited,adj)==true) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int node, int[] visited, int[] pathVisited, ArrayList<ArrayList<Integer>> adj) {
        visited[node]=1;
        pathVisited[node]=1;
        for (int it : adj.get(node)) {
            if (visited[it]==0) {
                if(dfs(it, visited, pathVisited, adj)){
                    return true;
                }
            }
            else if(pathVisited[it]==1){
                return true;
            }
        }
        pathVisited[node]=0;
        return false;
    }
}     
