package graph;


public class leetcode1905 {

    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] grid1 = {
            {1, 1, 1, 0, 0},
            {0, 1, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1}
        };

        int[][] grid2 = {
            {1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 1, 0, 0, 0},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0}
        };

        leetcode1905 solution = new leetcode1905();
        int result = solution.countSubIslands(grid1, grid2);
        System.out.println("Number of sub-islands: " + result);
    }

    int n;
    int m;
    int[] travRow = {-1,0,1,0};
    int[] travCol = {0,-1,0,1};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid2.length;
        m = grid2[0].length;
        int[][] visited = new int[n][m];
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                boolean[] sub = new boolean[1];
                if(grid2[i][j]==1 && visited[i][j]==0){
                    dfs(i,j,grid1,grid2,visited,sub);
                    if(!sub[0]){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j,int[][] grid1, int[][] grid2, int[][] visited,boolean[] sub){
        visited[i][j] =1;
        if (grid1[i][j]!=grid2[i][j]){
            sub[0] = true;
        }
        for(int k = 0;k<4;k++){
            int row = i + travRow[k];
            int col = j + travCol[k];
            if(row>=0 && row<n && col>=0 && col<m && grid2[row][col]==1 && visited[row][col]!=1){
                dfs(row,col,grid1,grid2,visited,sub);  
            }
        }
    }
}

