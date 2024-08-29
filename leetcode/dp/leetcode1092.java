package dp;

import java.util.*;
public class leetcode1092 {
    public static void main(String[] args) {
        leetcode1092 sol = new leetcode1092();
        System.out.println(sol.shortestCommonSupersequence("abac", "cab"));
    }
    public String shortestCommonSupersequence(String text1, String text2) {
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
        for(int[]arr:dp){
            System.out.println(Arrays.toString(arr));
        }
        StringBuilder ans = new StringBuilder();
        int i = text1.length();
        int j = text2.length();
        while(i>0 && j>0){
            char ch1 = text1.charAt(i-1);
            char ch2 = text2.charAt(j-1);
            if(ch1==ch2){
                // stack.add(ch1);
                ans.append(ch1);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                // stack.add(text1.charAt(i-1));
                ans.append(text1.charAt(i-1));
                i--;
            }else{
                // stack.add(text2.charAt(j-1));
                ans.append(text2.charAt(j-1));                
                j--;
            }
            System.out.println(ans);
        }
        while(i>0){
            ans.append(text1.charAt(i-1));
            i--;
        }
        while(j>0){
            ans.append(text2.charAt(j-1));  
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
    
}
