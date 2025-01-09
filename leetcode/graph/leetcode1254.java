package graph;

public class leetcode1254 {
    public static void main(String[] args) {
        
    }
    int n;
    int m;
    public int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[][] visited = new int[n][m];
        for(int i = 0;i<n;i++){
            if(grid[i][0]==0 && visited[i][0]==0){
                dfs(i,0,grid,visited);
            }
            if(grid[i][m-1]==0 && visited[i][m-1]==0){
                dfs(i,m-1,grid,visited);
            }
        }
        for(int i = 0;i<m;i++){
            if(grid[0][i]==0 && visited[0][i]==0){
                dfs(0,i,grid,visited);
            }
            if(grid[n-1][i]==0 && visited[n-1][i]==0){
                dfs(n-1,i,grid,visited);
            }
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==0 && visited[i][j]==0){
                    dfs(i,j,grid,visited);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private void dfs(int i, int j, int[][] grid, int[][] visited){
        visited[i][j] = 1;
        int[] travRow = {-1,0,1,0};
        int[] travCol = {0,-1,0,1};
        for(int k = 0;k<4;k++){
            int row = i + travRow[k];
            int col = j + travCol[k];
            if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==0 && visited[row][col]!=1){
                dfs(row,col,grid,visited);  
            }
        }
    }
}
