package graph;

import java.util.ArrayList;
import java.util.List;

public class leetcode797 {

    public static void main(String[] args) {
        int[][] graph = {{2}, {2}, {}};
        leetcode797 solution = new leetcode797();
        List<List<Integer>> result = solution.allPathsSourceTarget(graph);
        System.out.println(result);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0,n,graph,ans,path);
        return ans;
    }
    private void dfs(int vertex, int n, int[][] graph, List<List<Integer>> ans, List<Integer> list){
        if(vertex==n-1){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int node:graph[vertex]){
            list.add(node);
            dfs(node,n,graph,ans,list);
            list.remove(list.size()-1);
        }
    }
}
