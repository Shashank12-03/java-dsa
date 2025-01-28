package graph;

import java.util.Arrays;
public class leetcode329 {
    public static void main(String[] args) {
        int[][] matrix = {
            {7, 8, 9},
            {9, 7, 6},
            {7, 2, 3}
        };
        leetcode329 obj = new leetcode329();
        int result = obj.longestIncreasingPath(matrix);
        System.out.println("The longest increasing path is: " + result);
    }
    int n;
    int m;
    int[] travRow = {-1,0,1,0};
    int[] travCol = {0,-1,0,1};
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[n+1][m+1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                ans = Math.max(ans,dfs(i,j,matrix,dp));
            }
        }
        return ans;
    }
    private int dfs(int i, int j, int[][] matrix,int[][] dp){
        if (dp[i][j]!=-1) {
            return dp[i][j];
        }
        int len = 1;
        for(int k = 0;k<4;k++){
            int row = i + travRow[k];
            int col = j + travCol[k];
            if(row>=0 && row<n && col>=0 && col<m && (matrix[row][col]>matrix[i][j])){
                len = Math.max(len,1 + dfs(row, col, matrix, dp));
            }
        }
        return dp[i][j] = len;
    }
}
