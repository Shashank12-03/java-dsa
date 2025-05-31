package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode3373 {
    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
        int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        leetcode3373 obj = new leetcode3373();
        int[] ans = obj.maxTargetNodes(edges1, edges2);
        System.out.println(Arrays.toString(ans));
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
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
        int[][] dist1 = new int[m][m];
        
        bfs(0,m,adj2,true,dist1);
        for(int[] arr:dist1){
            System.out.println(Arrays.toString(arr));
        }
        // for(int i = 0;i<n;i++){
        //     distance[i] = bfs(i,n,adj1,false) + max;
        // }
        return distance;
    }
    
    private int bfs(int node, int k, List<List<Integer>> adj, boolean odd,int[][] dist) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{node,0});
        int[] visited = new int[k];
        visited[node] = 1;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int vertex = curr[0];
            int level = curr[1];
            if(odd && level%2==1){
                count++;
            }
            if(!odd && level%2==0){
                count++;
            }
            for(int nei:adj.get(vertex)){
                if(visited[nei]==0){
                    visited[nei]=1;
                    dist[vertex][nei] = level+1;
                    queue.add(new int[]{nei,level+1});
                }
            }
        }
        return count;
    }
}
