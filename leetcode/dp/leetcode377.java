package dp;

import java.util.Arrays;

public class leetcode377 {
    
    public static void main(String[] args) {
        
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return helper(nums,target,dp);
    }
    private int helper(int[] nums, int target,int[] dp){
        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(dp[target]!=-1){
            return dp[target];
        }
        int cnt = 0;
        for(int i = 0;i<nums.length;i++){
            cnt += helper(nums,target-nums[i],dp);
        }
        return dp[target] = cnt;
    }
}
