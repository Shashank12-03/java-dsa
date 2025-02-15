package graph;

import java.util.ArrayList; 
import java.util.List;

public class leetcode834 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1}, {0,2}, {2,3}, {2,4}, {2,5}};
        leetcode834 solution = new leetcode834();
        int[] result = solution.sumOfDistancesInTree(n, edges);
        for (int dist : result) {
            System.out.print(dist + " ");
        }
    }
    private int[] countChild;
    private int[] ans;
    private int totalDist;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        ans = new int[n];
        countChild = new int[n];
        totalDist = 0;
        dfs(0, -1, 0, adj);
        dfs2(0, -1, adj, n);
        return ans;
    }
    private int dfs(int i, int prev, int depth, List<List<Integer>> adj){
        int childNodes = 1;
        totalDist += depth;
        for(int node:adj.get(i)){
            if(node==prev){
                continue;
            }
            childNodes += dfs(node, i, depth+1, adj);
        }
        countChild[i] = childNodes;
        return childNodes;
    }
    private void dfs2(int node, int parent, List<List<Integer>> adj, int n) {
        ans[node] = totalDist;
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            totalDist += n - 2 * countChild[neighbor];
            dfs2(neighbor, node, adj, n);
            totalDist -= n - 2 * countChild[neighbor];
        }
    }
}
