package dp;

import java.util.Arrays;

public class leetcode1289 {
    public static void main(String[] args) {
        
    }
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n+1][n+1];
        
        for (int row = n-1; row >=0 ; row--) {
            for (int j = n; j >=0 ; j--) {
                int minSum = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    if (i != j) {
                        int sum = grid[row][i] + dp[row + 1][i];
                        minSum  = Math.min(minSum, sum);
                    }
                }
                dp[row][j + 1] = minSum;
            }
        }
        return dp[0][0];
    }
    // public int minFallingPathSum(int[][] grid) {
    //     int n = grid.length;
    //     int[][] dp = new int[n][n+1];
    //     for (int[] row : dp) {
    //         Arrays.fill(row, -1);
    //     }
    //     return helper(0,-1,grid,dp);
    // }
    // private int helper(int row,int colToNotTake,int[][] grid,int[][] dp){
    //     if(row>=grid.length){
    //         return 0;
    //     }
    //     if (dp[row][colToNotTake + 1] != -1) { 
    //         return dp[row][colToNotTake + 1];
    //     }
    //     int minSum = Integer.MAX_VALUE;
    //     for (int i = 0; i < grid[0].length; i++) {
    //         if (i != colToNotTake) {
    //             int sum = grid[row][i] + helper(row + 1, i, grid, dp);
    //             minSum  = Math.min(minSum, sum);
    //         }
    //     }

    //     dp[row][colToNotTake + 1] = minSum;
    //     return minSum;
    // }
}
