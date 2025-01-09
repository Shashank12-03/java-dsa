package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode934 {

    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
            // {0,1},
            // {1,0}
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
        };
        leetcode934 obj = new leetcode934();
        System.out.println(obj.shortestBridge(grid));
    }
    int n;
    int m;
    int[] travRow = {-1,0,1,0};
    int[] travCol = {0,-1,0,1};
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[][] visited = new int[n][m];
        List<List<Pair>> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    List<Pair> inner = new ArrayList<>();
                    dfs(i,j,grid,visited,inner);
                    list.add(inner);
                }
            }
        }
        for(int[] is:visited){
            System.out.println(Arrays.toString(is));
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<list.get(0).size();i++){
            Pair pair1 = list.get(0).get(i);
            int x1 = pair1.row;
            int y1 = pair1.col;
            for(int j = 0;j<list.get(1).size();j++){
                Pair pair2 = list.get(1).get(j);
                int x2 = pair2.row;
                int y2 = pair2.col;
                ans = Math.min(ans,Math.abs(x2-x1) + Math.abs(y2-y1));
            }
        }
        return ans-1;
    }
    private void dfs(int i, int j, int[][] grid, int[][] visited, List<Pair> list){
        visited[i][j] =1;
        list.add(new Pair(i,j));
        for(int k = 0;k<4;k++){
            int row = i + travRow[k];
            int col = j + travCol[k];
            if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==1 && visited[row][col]!=1){
                dfs(row,col,grid,visited,list);  
            }
        }
    }
}
