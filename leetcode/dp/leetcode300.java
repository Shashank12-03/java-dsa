package dp;

import java.util.*;

public class leetcode300 {
    public static void main(String[] args) {
        
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // int[] curr = new int[n+1];
        int[] dp = new int[n];
        // int[][] dp = new int[n+1][n+1];
        Arrays.fill(dp,1);
        // for(int i =0;i<n;i++){
        //     dp[n-1][i] = 0;
        // }
        
        int max = 1;
        for(int i =0;i<n;i++){
            for(int j =0;j<i;j++){
                // int notTake =next[j+1]; /*helper(nums,prev,ind+1,dp);*/
                // int take = 0;
                if(nums[j]<nums[i]){
                    dp[i] =Math.max(dp[i],1+dp[j]); /*helper(nums,ind,ind+1,dp);*/
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max; /*helper(nums,-1,0,dp);*/
    }
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     int[] curr = new int[n+1];
    //     int[] next = new int[n+1];
    //     // int[][] dp = new int[n+1][n+1];
    //     // for(int[] arr:dp){
    //     //     Arrays.fill(arr,-1);
    //     // }
    //     // for(int i =0;i<n;i++){
    //     //     dp[n-1][i] = 0;
    //     // }
    //     for(int i =n-1;i>=0;i--){
    //         for(int j =i-1;j>=-1;j--){
    //             int notTake =next[j+1]; /*helper(nums,prev,ind+1,dp);*/
    //             int take = 0;
    //             if(j==-1 || nums[j]<nums[i]){
    //                 take = 1 +next[i+1]; /*helper(nums,ind,ind+1,dp);*/
    //             }
    //             curr[j+1] = Math.max(take,notTake);
    //         }
    //         next = curr;
    //     }
    //     return next[0]; /*helper(nums,-1,0,dp);*/
    // }
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     int[][] dp = new int[n+1][n+1];
    //     // for(int[] arr:dp){
    //     //     Arrays.fill(arr,-1);
    //     // }
    //     // for(int i =0;i<n;i++){
    //     //     dp[n-1][i] = 0;
    //     // }
    //     for(int i =n-1;i>=0;i--){
    //         for(int j =i-1;j>=-1;j--){
    //             int notTake =dp[i+1][j+1]; /*helper(nums,prev,ind+1,dp);*/
    //             int take = 0;
    //             if(j==-1 || nums[j]<nums[i]){
    //                 take = 1 +dp[i+1][i+1]; /*helper(nums,ind,ind+1,dp);*/
    //             }
    //             dp[i][j+1] = Math.max(take,notTake);
    //         }
    //     }
    //     return dp[0][0]; /*helper(nums,-1,0,dp);*/
    // }
    // private int helper(int[]nums,int prev,int ind,int[][] dp){
    //     if(ind==nums.length){
    //         return 0;
    //     }
    //     if(dp[ind][prev+1]!=-1){
    //         return dp[ind][prev+1];
    //     }
    //     int notTake = helper(nums,prev,ind+1,dp);
    //     int take = 0;
    //     if(prev==-1 || nums[prev]<nums[ind]){
    //         take = 1 + helper(nums,ind,ind+1,dp);
    //     }
    //     return dp[ind][prev+1] = Math.max(take,notTake);
    // }
}
