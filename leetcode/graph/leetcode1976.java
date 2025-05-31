package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode1976 {

    static class Pair{
        int dest;
        int time;
        Pair(int dest,int time){
            this.dest = dest;
            this.time = time;
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] roads = {
            {0, 1, 1000000000}, {0, 3, 1000000000}, {1, 3, 1000000000},
            {1, 2, 1000000000}, {1, 5, 1000000000}, {3, 4, 1000000000},
            {4, 5, 1000000000}, {2, 5, 1000000000}
        };

        leetcode1976 obj = new leetcode1976();
        int result = obj.countPaths(n, roads);
        System.out.println("Number of ways: " + result);
    }


    public int countPaths(int n, int[][] roads){

        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }

        int[] ways = new int[n];
        ways[0] = 1;
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        int mod = (int)(1e9 + 7);
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int source = curr[0];
            int currTime = curr[1];
            
            for(Pair pair:adj.get(source)){
                int destination = pair.dest;
                int time = pair.time;
                if (currTime + time < distance[destination]) {
                    distance[destination] = currTime + time;
                    ways[destination] = ways[source];
                    pq.add(new int[]{destination, distance[destination]});
                } else if (currTime + time == distance[destination]) {
                    ways[destination] = (ways[destination] + ways[source]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}
