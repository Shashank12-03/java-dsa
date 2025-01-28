package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode851 {
    public static void main(String[] args) {
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        leetcode851 solution = new leetcode851();
        int[] result = solution.loudAndRich(richer, quiet);
        System.out.println(Arrays.toString(result));
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int people = quiet.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<people;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<richer.length;i++){
            adj.get(richer[i][0]).add(richer[i][1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[people];
        for(int i = 0;i<people;i++){
            for(int vrtx:adj.get(i)){
                indegree[vrtx]++;
            }
        }
        for(int i = 0;i<people;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int[] topo = new int[people];
        int j = 0;
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            topo[j++] = vertex;
            for(int node : adj.get(vertex)){
                indegree[node]--;
                if(indegree[node]==0){
                    queue.add(node);
                }
            }
        }
        System.out.println(Arrays.toString(topo));

        int[] ans = new int[people];
        for (int i = 0; i < people; i++) {
            ans[i] = i;
        }
        for (int person : topo) {
            for (int neighbor : adj.get(person)) {
                if (quiet[ans[person]] < quiet[ans[neighbor]]) {
                    ans[neighbor] = ans[person];
                }
            }
        }
        return ans;
    }
}
