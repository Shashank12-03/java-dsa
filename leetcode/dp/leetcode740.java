package dp;

import java.util.Arrays;

public class leetcode740 {
    public static void main(String[] args) {
        
    }
    public int deleteAndEarnTab(int[] nums) {
        int[] temp = new int[10001];
        int[] dp = new int[temp.length+1];
        // Arrays.fill(dp,-1);
        for(int i =0;i<nums.length;i++){
            temp[nums[i]]++;
        }
        dp[1] = Math.max(temp[0], temp[1]);
        for (int i = 2; i < dp.length; i++) {
            if (temp[i] == 0) {
                dp[i] = dp[i - 1];
            }
            int notPick = dp[i-1];
            int pick = i*temp[i] + dp[i-2];
            dp[i] = Math.max(notPick,pick);
        }
        // return helper(0,map,dp);
        return dp[temp.length];
    }

    public int deleteAndEarn(int[] nums) {
        int[] map = new int[10001];
        int[] dp = new int[map.length+1];
        Arrays.fill(dp,-1);
        for(int i =0;i<nums.length;i++){
            map[nums[i]]++;
        }
        return helper(map.length-1,map,dp);
    }
    private int helper(int curr,int[] temp,int[] dp){
        if(curr==0){
            return temp[curr];
        }
        if(curr<0){
            return 0;
        }
        if(dp[curr]!=-1){
            return dp[curr];
        }
        if (temp[curr] == 0) {
            return helper(curr - 1,temp,dp);  // Move to the next element
        }
        int notPick = helper(curr-1,temp,dp);
        int pick = curr*temp[curr] + helper(curr-2,temp,dp);
        return dp[curr] = Math.max(notPick,pick);
    }
}
