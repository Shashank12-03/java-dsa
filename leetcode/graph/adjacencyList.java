package graph;

import java.util.*;

class adjacencyList {

    public static void main(String[] args) {
        
        List<List<Integer>> ans= printGraph(5, new int[][]{{0,1},{0,4},{4,1},{4,3},{1,3},{1,2},{3,2}});
        for(List<Integer> list:ans){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Integer> inner = new ArrayList<>();
            for (int j = 0; j < edges.length; j++) {
                if (edges[j][0]==i){
                    inner.add(edges[j][1]);
                }
                else if (edges[j][1]==i){
                    inner.add(edges[j][0]);
                }
            }
            ans.add(inner);
        }
        return ans;
    }
}