package graph;

import java.util.ArrayList;
import java.util.List;

public class leetcode1857 {
    public static void main(String[] args) {
        leetcode1857 obj = new leetcode1857();
        String colors = "abaca";
        int[][] edges = {{0,1},{0,2},{2,3},{3,4}};
        int result = obj.largestPathValue(colors, edges);
        System.out.println(result); 
    }
    public int largestPathValue(String colors, int[][] edge) {
        List<List<Integer>> adj = new ArrayList<>( );
        int n = colors.length();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edge.length;i++){
            adj.get(edge[i][0]).add(edge[i][1]);
        }
        int[][] count = new int[n][26];
        int res = 0;
        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        char [] colorArray = colors.toCharArray();
        for(int i = 0;i<n;i++){
            if(visited[i]==0){
                int dfsResult = dfs(i,count,colorArray,adj,pathVisited,visited);
                res = Math.max(res,dfsResult);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
    private int dfs(int node, int[][] count, char[] colors, List<List<Integer>> adj, int[] pathVisited, int[] visited){
        if(visited[node]==1){
            return 0;
        }
        else if(pathVisited[node]==1){
            return Integer.MAX_VALUE;
        }
        visited[node] = 1;
        pathVisited[node] = 1;
        int colorIndex = colors[node]-'a'; 
        count[node][colorIndex] = 1;
        for(int nei:adj.get(node)){
            if (dfs(nei,count,colors,adj,pathVisited,visited)==Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            for(int i = 0;i<26;i++){
                count[node][i] = Math.max(count[node][i], count[nei][i] + ( ( i== colorIndex ) ? 1 : 0 ));
            }
        }
        int max = 0;
        for(int i = 0;i<26;i++){
            max = Math.max(max,count[node][i]);
        }
        pathVisited[node] = 0;
        return max;
    }
}
