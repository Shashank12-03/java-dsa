package dp;

import java.util.*;

public class leetcode673 {
    public static void main(String[] args) {
        
    }
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // int[] curr = new int[n+1];
        int[] dp = new int[n];
        int[] cnt = new int[n];
        // int[][] dp = new int[n+1][n+1];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        // for(int i =0;i<n;i++){
        //     dp[n-1][i] = 0;
        // }

        int max = 1;
        for(int i =0;i<n;i++){
            for(int j =0;j<i;j++){
                // int notTake =next[j+1]; /*helper(nums,prev,ind+1,dp);*/
                // int take = 0;
                if(nums[j]<nums[i] && dp[i]<1+dp[j]){
                    dp[i] = 1+dp[j]; /*helper(nums,ind,ind+1,dp);*/
                    cnt[i] = cnt[j];
                }
                else if (nums[j]<nums[i] && dp[i]==1+dp[j]) {
                    cnt[i]+=cnt[j];
                }
            }
            max = Math.max(max,dp[i]);
        }
        int nos = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (dp[i]==max) {
                nos+=cnt[i];
            }
        }
        return nos; /*helper(nums,-1,0,dp);*/
    }
}
