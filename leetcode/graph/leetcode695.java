package graph;

public class leetcode695 {
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        leetcode695 solution = new leetcode695();
        int maxArea = solution.maxAreaOfIsland(grid);
        System.out.println("Max area of island: " + maxArea);
    }
    int maxConnected;
    int n;
    int m;
    public int maxAreaOfIsland(int[][] grid) {
        maxConnected = 0;
        n = grid.length;
        m = grid[0].length;
        int[][] visited = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    int[] connected = new int[1];
                    dfs(i,j,grid,visited,connected);
                    maxConnected = Math.max(maxConnected,connected[0]);
                }
            }
        }
        return maxConnected;
    }
    private void dfs(int i, int j, int[][] grid, int[][] visited, int[] connected){
        visited[i][j] = 1;
        connected[0]++;
        int[] travRow = {-1,0,1,0};
        int[] travCol = {0,-1,0,1};
        for(int k = 0;k<4;k++){
            int row = i + travRow[k];
            int col = j + travCol[k];
            if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==1 && visited[row][col]!=1){
                dfs(row,col,grid,visited,connected);  
            }
        }
    }
}
