package graph;

public class leetcode547 {
    public static void main(String[] args) {
        int[][] isConnected={{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count=0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }
    private static void dfs(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(i, isConnected, visited);
            }
        }
    } 
    // public static int findCircleNum(int[][] isConnected) {
    //     ArrayList<ArrayList<Integer>> adjls=tolist(isConnected);
    //     boolean[] visited = new boolean[isConnected.length];
    //     int count=0;
    //     for (int i = 0; i < visited.length; i++) {
    //         if (!visited[i]) {
    //             count++;
    //             dfs(i, adjls , visited);
    //         }
    //     }
    //     return count;
    // }
    // private static void dfs(int node,ArrayList<ArrayList<Integer>> adjls, boolean[]visited){
    //     visited[node]=true;
    //     for (Integer num :adjls.get(node)) {
    //         if (!visited[num]) {
    //             dfs(num, adjls, visited);
    //         }
    //     }
    // } 
    // private static ArrayList<ArrayList<Integer>> tolist(int[][]isConnected){
    //     ArrayList<ArrayList<Integer>> adjls=new ArrayList<ArrayList<Integer>>();
    //     for (int i = 0; i < isConnected.length; i++) {
    //         adjls.add(new ArrayList<Integer>());
    //     }
    //     for (int i = 0; i < isConnected.length; i++) {
    //         for (int j = 0; j < isConnected.length; j++) {
    //             if (isConnected[i][j]==1 && i!=j) {
    //                 adjls.get(i).add(j);
    //                 adjls.get(j).add(i);
    //             }
    //         }
    //     }
    //     return adjls;
    // } 
}
