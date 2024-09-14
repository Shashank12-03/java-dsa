package dp;

import java.util.*;

public class leetcode474 {
    public static void main(String[] args) {
        leetcode474 sol = new leetcode474();
        System.out.println(sol.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for (int[][] is : dp) {
            for (int[] is2 : is) {
                Arrays.fill(is2,-1);
            }
        }
        for (int i = 0; i <=m; i++) {
            for (int j = 0; j <=n; j++) {
                dp[strs.length][i][j] = 0;
            }
        }
        for (int i = strs.length-1; i>=0 ; i--) {
            for (int j = 0; j <=m; j++) {
                for (int j2 = 0; j2 <=n; j2++) {
                    int notTake =dp[i+1][m][n]; /*helper(strs,ind+1,m,n,dp);*/
                    int[] cnt = getCount(strs[i]);
                    int take = 0; 
                    if (j>=cnt[0] && j2>=cnt[1]){
                        take = 1+dp[i+1][j-cnt[0]][j2-cnt[1]]; /*helper(strs,ind+1,m-cnt[0],n-cnt[1],dp);*/
                    }
                    dp[i][j][j2] = Math.max(notTake, take);
                }
            }
        }
        // return helper(strs,0,m,n,dp);
        return dp[0][m][n];
    }
    // private int helper(String[] strs,int ind,int m, int n,int[][][]dp){
    //     if(ind==strs.length){
    //         return 0;
    //     }
    //     if (dp[ind][m][n]!=-1) {
    //         return dp[ind][m][n];
    //     }
    //     int notTake = helper(strs,ind+1,m,n,dp);
    //     int[] cnt = getCount(strs[ind]);
    //     int take = 0; 
    //     if (m>=cnt[0] && n>=cnt[1]){
    //         take = 1+ helper(strs,ind+1,m-cnt[0],n-cnt[1],dp);
    //     }
    //     return dp[ind][m][n] = Math.max(notTake, take);
    // }
    private int[] getCount(String str){
        int[] count = new int[2];
        for(char ch:str.toCharArray()){
            if (ch=='1'){
                count[1]++;
            }else{
                count[0]++;
            }
        }
        return count;
    }
}
