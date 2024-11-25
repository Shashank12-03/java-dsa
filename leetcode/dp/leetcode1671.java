package dp;

import java.util.*;


public class leetcode1671 {
    public static void main(String[] args) {
        leetcode1671 sol = new leetcode1671();
        System.out.println(sol.minimumMountainRemovals(new int[]{2,1,1,5,6,2,3,1}));
    }
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        // int[] curr = new int[n+1];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        // int[][] dp = new int[n+1][n+1];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        // for(int i =0;i<n;i++){
        //     dp[n-1][i] = 0;
        // }

        int max1 = 1;
        int max2 = 1;
        for(int i =0;i<n;i++){
            for(int j =0;j<i;j++){
                // int notTake =next[j+1]; /*helper(nums,prev,ind+1,dp);*/
                // int take = 0;
                if(nums[j]<nums[i]){
                    dp1[i] =Math.max(dp1[i],1+dp1[j]); /*helper(nums,ind,ind+1,dp);*/
                }
                if(nums[j]>nums[i]){
                    dp2[i] =Math.max(dp2[i],1+dp2[j]); /*helper(nums,ind,ind+1,dp);*/
                }
            }
            max1 = Math.max(max1,dp1[i]);
            max2 = Math.max(max2,dp2[i]);
        }
        return nums.length-(max1+max2-1);
    }
}
