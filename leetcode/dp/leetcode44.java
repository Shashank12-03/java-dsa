package dp;

import java.util.*;

public class leetcode44 {
    public static void main(String[] args) {
        leetcode44 sol = new leetcode44();
        System.out.println(sol.isMatch("mississippi","m??*ss*?i*pi"));
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return helper(s.toCharArray(),p.toCharArray(),n-1,m-1,dp);
    }
    private boolean helper(char[] s, char[] p, int i, int j, int[][] dp) {
        if(i<0 && j<0){
            return true;
        }
        if (j<0 && i>=0){
            return false;
        }
        if (i<0 && j>=0){
            if(j==0 && p[j]=='?'){
                return true;
            }
            for (int k = 0; k <= j; k++) {
                if (p[k]!='*'){
                    return false;
                }
            }
            return true;
        }
        if (dp[i][j]!=-1){
            return dp[i][j]==1?true:false;
        }
        if(s[i]==p[j] || p[j]=='?'){
            dp[i][j]=helper(s, p, i-1, j-1,dp)?1:0;
            return dp[i][j]==1?true:false;
        }
        if(p[j]=='*'){
            dp[i][j]= (helper(s, p, i-1, j,dp) || helper(s, p, i, j-1,dp))?1:0;
            return dp[i][j]==1?true:false;
        }
        dp[i][j]=0;
        return false;
    }
}
