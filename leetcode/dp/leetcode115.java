package dp;

import java.util.*;
public class leetcode115 {
    public static void main(String[] args) {
        
    }
    public int numDistinctTab(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr, -1);
        // }
        for (int index = 0; index <=n; index++) {
            dp[index][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if(s.charAt(i)==t.charAt(j)){
                    dp[i][j] =dp[i-1][j-1] + dp[i-1][j]; /*helper(s,t,i-1,j-1,dp) + helper(s,t,i-1,j,dp);*/
                }else{
                    dp[i][j] =dp[i-1][j]; /*helper(s,t,i-1,j,dp);*/
                }
            }
        }
        return dp[n-1][m-1]; /*helper(s.toCharArray(),t.toCharArray(),s.length()-1,t.length()-1,dp);*/
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return helper(s.toCharArray(),t.toCharArray(),s.length()-1,t.length()-1,dp);
    }
    private int helper(char[]s,char[]t,int i ,int j,int[][]dp){
        if (j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s[i]==t[j]){
            return dp[i][j] = helper(s,t,i-1,j-1,dp) + helper(s,t,i-1,j,dp);
        }else{
            return dp[i][j] = helper(s,t,i-1,j,dp);
        }
    }
}
