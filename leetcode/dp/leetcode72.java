package dp;

import java.util.*;
public class leetcode72 {
    public static void main(String[] args) {
        leetcode72 sol = new leetcode72();
        System.out.println(sol.minDistanceTab("horse", "ros"));
    }
    public int minDistanceTab(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <=n; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <=m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]; /*helper(word1, word2, i-1, j-1,dp);*/
                }
                else{
                    int add = 1+ dp[i][j-1]; /*helper(word1, word2, i, j-1,dp);*/
                    int remove = 1+ dp[i-1][j]; /*helper(word1, word2, i-1, j,dp);*/
                    int replace = 1+dp[i-1][j-1]; /*helper(word1, word2, i-1, j-1,dp);*/
                    dp[i][j] = Math.min(add,Math.min(remove, replace));
                }
            }
        }
        return dp[n][m];
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return helper(word1.toCharArray(),word2.toCharArray(),n,m,dp);
    }
    private int helper(char[] word1, char[] word2, int i, int j,int[][]dp) {
        if (i==0){
            return j;
        }
        if (j==0){
            return i;
        }
        if (dp[i][j]!=-1) {
            return dp[i][j];
        }
        if (word1[i-1]==word2[j-1]) {
            return helper(word1, word2, i-1, j-1,dp);
        }
        int add = 1+ helper(word1, word2, i, j-1,dp);
        int remove = 1+ helper(word1, word2, i-1, j,dp);
        int replace = 1+ helper(word1, word2, i-1, j-1,dp);
        return dp[i][j] = Math.min(add,Math.min(remove, replace));
    }
}
