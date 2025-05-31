package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode3372 {
    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
        int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        int k = 2;
        leetcode3372 obj = new leetcode3372();
        obj.maxTargetNodes(edges1, edges2, k);
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        
        int n = edges1.length +1;
        int m = edges2.length + 1;
        for(int i = 0;i<n;i++){
            adj1.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            adj2.add(new ArrayList<>());
        }
        for(int i = 0;i<edges1.length;i++){
            adj1.get(edges1[i][0]).add(edges1[i][1]);
            adj1.get(edges1[i][1]).add(edges1[i][0]);
        }
        for(int i = 0;i<edges2.length;i++){
            adj2.get(edges2[i][0]).add(edges2[i][1]);
            adj2.get(edges2[i][1]).add(edges2[i][0]);
        }
        int[] distance = new int[n];
        int max = 0;
        for(int i = 0;i<m;i++){
            int[] visited2 = new int[m];
            max = Math.max(max,dfs(i,k-1,adj2,visited2));
        }
        System.out.println("Max nodes reachable from edges2: " + max);
        for(int i = 0;i<n;i++){
            int[] visited1 = new int[n];
            distance[i] = dfs(i,k,adj1,visited1) + max;
        }
        System.out.println(Arrays.toString(distance));
        return distance;
    }
    
    private int dfs(int node, int k, List<List<Integer>> adj, int[] visited) {
        if (k < 0) return 0;
        
        visited[node] = 1;
        int count = 1;  // count this node
        
        for (int nei : adj.get(node)) {
            if (visited[nei] == 0) {
                count += dfs(nei, k - 1, adj, visited);
            }
        }
        return count;
    }
}
