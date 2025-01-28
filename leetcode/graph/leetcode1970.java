package graph;


public class leetcode1970 {
    public static void main(String[] args) {
        int row = 2;
        int col = 2;
        int[][] cells = {
            {1, 1}, {1, 2}, {2, 1}, {2, 2}
        };
        leetcode1970 solution = new leetcode1970();
        int result = solution.latestDayToCross(row, col, cells);
        System.out.println("The latest day to cross is: " + result);
    }

    int n;
    int m;
    int[] travRow = {-1,0,1,0};
    int[] travCol = {0,-1,0,1};
    public int latestDayToCross(int row, int col, int[][] cells) {
        n = row;
        m = col;
        int low = 1;
        int high = cells.length;
        while(low<high){
            int mid = high - (high - low) / 2;
            if (canReach(mid,cells)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    private boolean canReach(int day,int[][] cells){
        int[][] grid = new int[n][m];
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        int[][] visited = new int[n][m];
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 0 && dfs(0, i, grid, visited)) {
                return true;
            }
        }
        return false;
    }
    private boolean dfs(int i, int j, int[][] grid, int[][] visited){
        visited[i][j] = 1;
        if (i==n-1){
            return true;
        }
        for(int k = 0;k<4;k++){
            int row = i + travRow[k];
            int col = j + travCol[k];
            if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==0 && visited[row][col]==0){
                if(dfs(row,col,grid,visited)){
                    return true;
                }  
            }
        }
        return false;
    }
}
