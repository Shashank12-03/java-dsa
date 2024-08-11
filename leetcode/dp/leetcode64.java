package dp;

// import java.util.Arrays;

public class leetcode64 {
    public static void main(String[] args) {
        leetcode64 sol = new leetcode64();
        System.out.println(sol.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j] = grid[i][j];
                }
                else{
                    int right=grid[i][j];
                    int down=grid[i][j];
                    if(i>0){
                        down = grid[i][j]+dp[i-1][j];
                    }else{
                        down +=(int)1e9;
                    }
                    if(j>0){
                        right = grid[i][j]+dp[i][j-1];
                    }else{
                        right +=(int)1e9;
                    }
                    dp[i][j] = Math.min(right, down);
                }
            }
        }
        return dp[n-1][m-1];
        // return helper(grid,n-1,m-1,dp);
    }
    // private int helper(int[][] grid,int row,int col,int[][] dp){
    //     if(row==0 && col==0){
    //         return grid[row][col];
    //     }
    //     if (row<0 ||col<0){
    //         return (int)1e9;
    //     }
    //     if (dp[row][col]!=-1){
    //         return dp[row][col];
    //     }
    //     int right = grid[row][col]+helper(grid,row,col-1,dp);
    //     int down = grid[row][col]+helper(grid,row-1,col,dp);
    //     return dp[row][col]=Math.min(right,down);
    // }
}
