package dp;

import java.util.Arrays;

public class leetcode132 {
    public static void main(String[] args) {
        leetcode132 sol = new leetcode132();
        System.out.println(sol.minCut("aab"));
    }
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        for (int i = n-1; i >=0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j<n; j++) {
                if (palindrome(i,j,s.toCharArray())) {
                    int cost = 1 +dp[j+1]; /*helper(s,j+1,n,dp);*/
                    min = Math.min(min, cost);
                }
            }
            dp[i] = min;
        }
        return dp[0]; /*helper(s.toCharArray(),0,s.length(),dp)-1;*/
    }
    // private int helper(char[] str, int i,int n,int[] dp) {
    //     if (i==n) {
    //         return 0;
    //     }
    //     if (dp[i]!=-1){
    //         return dp[i];
    //     }
    //     int min = Integer.MAX_VALUE;
    //     for (int j =i; j < n; j++) {
    //         if (palindrome(i,j,str)) {
    //             int cost = 1 + helper(str,j+1,n,dp);
    //             min = Math.min(min, cost);
    //         }
    //     }
    //     return dp[i] = min;
    // }
    private boolean palindrome(int i, int j,char[] str) {
        while (i<j) {
            if(str[i]!=str[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
