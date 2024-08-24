package graph;

import java.util.ArrayList;
import java.util.List;

public class leetcode1443 {

    public static void main(String[] args) {
        leetcode1443 sol = new leetcode1443();
        List<Boolean> list = new ArrayList<>();
        list.add(false);
        list.add(false);
        list.add(true);
        list.add(false);
        list.add(true);
        list.add(true);
        list.add(false);
        System.out.println(sol.minTime(7, new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}},list));
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i <edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int time = dfs(0,adj,hasApple,new boolean[hasApple.size()]);
        return time>0?time-2:0;
    }
    private int dfs(int node, List<List<Integer>> adj, List<Boolean> hasApple, boolean[] visited) {
        // visited[vertx] = true;
        if (visited[node]) {
            return 0;
        }
        visited[node] = true;
        List<Integer> childs = adj.get(node);
        int time = 0;
        for (int child : childs) {
            time += dfs(child, adj, hasApple, visited);
        }
        if (time > 0 || hasApple.get(node)) {
            time += 2;
        }
        return time;
    }
}