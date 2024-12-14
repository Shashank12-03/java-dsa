package dp;

import java.util.Arrays;

public class leetcode1277 {
    public static void main(String[] args) {
        System.out.println(countSquares(new char[][]{{'0', '1'},{'1', '0'}}));
    }
    public static int countSquares(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for(int i =0;i<m;i++){
            dp[0][i] = matrix[0][i]-'0';
            max = Math.max(max,dp[0][i]);
        }
        for(int i =0;i<n;i++){
            dp[i][0] = matrix[i][0]-'0';
            max = Math.max(max,dp[i][0]);
        }
        for(int i =1;i<n;i++){
            for(int j =1;j<m;j++){
                if(matrix[i][j]-'0'==0){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        for(int[] is:dp){
            System.out.println(Arrays.toString(is));
        }
        int cnt = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                cnt+=dp[i][j];
            }
        }
        return cnt;
    }
}
