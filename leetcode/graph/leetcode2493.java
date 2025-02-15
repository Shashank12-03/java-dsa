package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode2493 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{1, 2}, {1, 4}, {1, 5}, {2, 6}, {2, 3}, {4, 6}};
        leetcode2493 solution = new leetcode2493();
        int result = solution.magnificentSets(n, edges);
        System.out.println("The result is: " + result);
    }
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int[] visited = new int[n+1];
        int ans = 0;
        
        for(int i = 1; i <= n; i++) {
            if(visited[i] == 0) {
                List<Integer> component = getConnectedComponent(n, i, adj, visited);
                int maxGrp = 0;
                for(int node : component) {
                    int length = bfs(n, node, adj);
                    if(length == -1) {
                        return -1;
                    }
                    maxGrp = Math.max(maxGrp, length);
                }
                ans += maxGrp;
            }
        }
        return ans;
    }
    
    private List<Integer> getConnectedComponent(int n, int src, List<List<Integer>> adj, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        visited[src] = 1;
        queue.add(src);
        list.add(src);
        
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            for(int node : adj.get(vertex)) {
                if(visited[node] == 0) {
                    visited[node] = 1;
                    queue.add(node);
                    list.add(node);
                }
            }
        }
        return list;
    }
    
    private int bfs(int n, int src, List<List<Integer>> adj) {
        Queue<int[]> queue = new LinkedList<>();
        int[] visited = new int[n+1];
        visited[src] = 1;
        queue.add(new int[]{src, 1});
        int maxLen = 1;  // Initialize with 1 since source node is in group 1
        
        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            int vertex = pair[0];
            int len = pair[1];
            
            for(int node : adj.get(vertex)) {
                if(visited[node] == 0) {
                    visited[node] = len + 1;
                    maxLen = Math.max(maxLen, len + 1);
                    queue.add(new int[]{node, len + 1});
                } else if(visited[node] == len) {
                    return -1;  // Found nodes at same level connected to each other
                }
            }
        }
        return maxLen;
    }
}
