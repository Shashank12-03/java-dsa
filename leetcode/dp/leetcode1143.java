package dp;

import java.util.*;

public class leetcode1143 {
    public static void main(String[] args) {
        leetcode1143 sol = new leetcode1143();
        // StringBuilder ans = new Str/ingBuilder(); 
        System.out.println(sol.longestCommonSubsequence("abcde", "ace"));
        System.out.println(sol.longestCommonSubsequenceTab("bbbab", "babbb"));

    }
    public int longestCommonSubsequenceTab(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr, -1);
        // }
        for (int i = 0; i <=n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <=m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <=n; i++) {
            for (int k = 1; k <=m; k++) {
                if (text1.charAt(i-1)==text2.charAt(k-1)){
                    dp[i][k] = 1+ dp[i-1][k-1];  /*helper(text1, text2, i-1, j-1,dp);*/
                }else{
                    dp[i][k] = Math.max( dp[i-1][k]  /*helper(text1, text2, i-1, j,dp)*/,dp[i][k-1] /*helper(text1, text2, i, j-1,dp)*/);
                }
            }
        }
        return  dp[text1.length()][text2.length()]; /*helper(text1.toCharArray(),text2.toCharArray(),text1.length()-1,text2.length()-1,dp);*/
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return helper(text1.toCharArray(),text2.toCharArray(),text1.length()-1,text2.length()-1,dp);
    }
    private int helper(char[] text1, char[] text2, int i, int j,int[][] dp) {
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        } 
        if (text1[i]==text2[j]){
            return dp[i][j] = 1+helper(text1, text2, i-1, j-1,dp);
        }else{
            return dp[i][j] = Math.max(helper(text1, text2, i-1, j,dp), helper(text1, text2, i, j-1,dp));
        }
    }
}
