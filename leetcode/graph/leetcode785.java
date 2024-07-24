package graph;

public class leetcode785 {
    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
    }
    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < color.length; i++) {
            if (color[i]==-1){
                if(!dfs(i,0,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean dfs(int node, int clr, int[][] graph, int[] color) {
        color[node] = clr;

        for (int j : graph[node]) {
            if (color[j]==-1){
                if(!dfs(j, 1-clr, graph, color)){
                    return false;
                }
            }
            else if(color[j]==clr){
                return false;
            }
        }
        return true;
    }
}
