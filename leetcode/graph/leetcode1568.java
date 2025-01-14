package graph;


public class leetcode1568 {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1},
            {1, 1, 0, 1, 1}
        };
        leetcode1568 solution = new leetcode1568();
        int result = solution.minDays(grid);
        System.out.println(result);
    }
    int n;
    int m;
    public int minDays(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        if (isDisconnected(grid)) {
            return 0;
        }
        int[][] visited = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    grid[i][j]=0;
                    if(isDisconnected(grid)){
                        return 1;
                    }
                    grid[i][j]=1;
                }
            }
        }
        return 2;
    }
    private boolean isDisconnected(int[][]grid){
        int[][] visited = new int[n][m];
        int land = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    if (land>0) {
                        return true;
                    }
                    dfs(i,j,grid,visited);
                    land++;
                }
            }
        }
        return land!=1;
    }
    private void dfs(int i, int j, int[][] grid, int[][] visited){
        visited[i][j] = 1;
        int[] travRow = {-1,0,1,0};
        int[] travCol = {0,-1,0,1};
        for(int k = 0;k<4;k++){
            int row = i + travRow[k];
            int col = j + travCol[k];
            if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==1 && visited[row][col]!=1){
                dfs(row,col,grid,visited);  
            }
        }
    }
}
