package graph;

import java.util.Arrays;

public class leetcode2359 {
    public static void main(String[] args) {
        int[] edges = {5,4,5,4,3,6,-1};
        int node1 = 0;
        int node2 = 1;
        leetcode2359 solution = new leetcode2359();
        System.out.println(solution.closestMeetingNode(edges, node1, node2));
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] distFromNode1 = new int[n];
        int[] distFromNode2 = new int[n];
        int[] pathVisited1 = new int[n];
        int[] pathVisited2 = new int[n]; 
        Arrays.fill(distFromNode1,Integer.MAX_VALUE);
        Arrays.fill(distFromNode2,Integer.MAX_VALUE);
        dfs(node1,0,edges,distFromNode1,pathVisited1);
        System.out.println(Arrays.toString(distFromNode1));
        dfs(node2,0,edges,distFromNode2,pathVisited2);
        System.out.println(Arrays.toString(distFromNode2));
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            if(min>=Math.max(distFromNode1[i], distFromNode2[i])){
                ans = i;
                min = Math.max(distFromNode1[i], distFromNode2[i]);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
    private void dfs(int node,int dist, int[] edges, int[] distance, int[] pathVisited){
        if(pathVisited[node] == 1){
            return;
        }
        if(distance[node]!=Integer.MAX_VALUE){
            return;
        }
        distance[node] = dist;
        pathVisited[node] = 1;
        if(edges[node]!=-1){
            dfs(edges[node],dist+1,edges,distance,pathVisited);
        }
        pathVisited[node] = 0;
    }
}
