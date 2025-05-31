package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode743 {

    class Pair{
        int dest;
        int time;
        Pair(int dest,int time){
            this.dest = dest;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        leetcode743 solution = new leetcode743();
        int result = solution.networkDelayTime(times, n, k);
        System.out.println("Network Delay Time: " + result);
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{k,0});
        
        while(!queue.isEmpty()){
            int[] curr = queue.peek();
            queue.remove();
            int node = curr[0];
            int currTime = curr[1];
            for(Pair pair :adj.get(node)){
                int vertex = pair.dest;
                int time = pair.time;
                if(time + currTime < distance[vertex]){
                    distance[vertex] = time + currTime;
                    queue.add(new int[]{vertex ,time+currTime});
                }
            }
        }
        int ans = 0;
        for(int i = 1;i<=n;i++){
            if(distance[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans,distance[i]);
        }
        return ans;
    }
}
