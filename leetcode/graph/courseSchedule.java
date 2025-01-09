package graph;

import java.util.ArrayList;
import java.util.Stack;

public class courseSchedule {
    public static void main(String[] args) {
        
        int n = 25;
        int m = 14;
        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
        int[][] input = {
            {10, 18}, {0, 18}, {10, 6}, {16, 0}, {8, 7}, {19, 15}, {24, 16}, {20, 14},
            {1, 17}, {14, 13}, {21, 21}, {19, 22}, {23, 20}, {10, 5}
        };
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(input[i][0]);
            pair.add(input[i][1]);
            prerequisites.add(pair);
        }
        int[] order = findOrder(n, m, prerequisites);
        for (int course : order) {
            System.out.print(course + " ");
        }
    }
    
    
    public static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ;i<m;i++){
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }
        
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
        
        
        int[] visited = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0 ;i<n;i++){
            if(visited[i]==0){
                topoSort(i,adj,visited,stk);
            }
        }
        if(stk.size()!=n || isCyclic(n,adj)){
            return new int[]{};
        }
        int[] ans = new int[n];
        int i = 0;
        while(!stk.isEmpty()){
            ans[i] = stk.pop();
            i++;
        }
        return ans;
    }
    private static void topoSort(int vertex,ArrayList<ArrayList<Integer>> adj,int[] visited,Stack<Integer> stk){
        visited[vertex] = 1;
        for(int node:adj.get(vertex)){
            if(visited[node]==0){
                topoSort(node,adj,visited,stk);
            }
        }
        stk.push(vertex);
    }
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
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
    private static boolean dfs(int node, int[] visited, int[] pathVisited, ArrayList<ArrayList<Integer>> adj) {
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
