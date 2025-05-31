package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode368 {
    public static void main(String[] args) {
        int[] nums = {4,8,10,240};
        leetcode368 solution = new leetcode368();
        List<Integer> result = solution.largestDivisibleSubset(nums);
        System.out.println("Largest Divisible Subset: " + result);
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        int lastIndex = -1;
        int max = 0;
        for (int i = 0; i < n; i++){
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && 1+dp[prev]>dp[i]) {
                    dp[i] = Math.max(dp[i], dp[prev] + 1);
                    hash[i] = prev;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (max < dp[i]) {
                max = dp[i];
                lastIndex = i;
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(hash));

        ans.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            ans.add(nums[lastIndex]);
        }
        Collections.reverse(ans);
        return ans;
    }
    private int helper(int ind, int prev, int[] nums, List<Integer> ans,int[][] dp){
        if(ind>=nums.length){
            return 0;
        }
        if(dp[ind][prev+1]!=-1){
            return dp[ind][prev+1];
        }
        int notPick = helper(ind+1,prev,nums,ans,dp);
        int pick = 0;
        if (prev==-1 || nums[ind]%nums[prev]==0){
            ans.add(nums[ind]);
            pick = 1 + helper(ind+1,ind,nums,ans,dp);
        }
        return dp[ind][prev+1] = Math.max(notPick,pick);
    }
}
