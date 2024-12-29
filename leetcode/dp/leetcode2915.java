package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode2915 {
    public static void main(String[] args) {
        leetcode2915 sol = new leetcode2915();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(5);
        System.out.println(sol.lengthOfLongestSubsequence(list, 3));
    }

    int[][] dp;
    public int lengthOfLongestSubsequenceTab(List<Integer> nums, int target) {
        int n =nums.size();
        dp = new int[n][target+1];
        for (int ind = 1; ind<n; ind++) {
            for (int targ = 0; targ < dp[0].length; targ++) {
                int notPick = dp[ind-1][targ]; /*helper(nums,target,ind+1,n);*/
                int pick  = -1001;
                if(targ>=nums.get(ind)){
                    pick = 1 + dp[ind+1][targ-nums.get(ind)];/*  helper(nums,target-nums.get(ind),ind+1,n);*/
                }
                dp[ind][targ] = Math.max(notPick,pick); 
            }
        }
        int ans =dp[n][target]; /*helper(nums,target,0,n);*/
        return ans==-1001?-1:ans;
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n =nums.size();
        dp = new int[n+1][target+1];
        for (int[] row : dp) {
            Arrays.fill(row,-1);
        }
        for (int i = 0; i < dp.length; i++) {
            
        }
        int ans = helper(nums,target,0,n);
        return ans==-1001?-1:ans;
    }
    private int helper(List<Integer> nums, int target, int ind,int n){

        if(ind>=n){
            if(target>0){
                return -1001;
            }
            return 0;
        }
        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }
        int notPick = helper(nums,target,ind+1,n);
        int pick  = -1001;
        if(target>=nums.get(ind)){
            int next =  helper(nums,target-nums.get(ind),ind+1,n);
            if(next!=-1001){
                pick = 1+next;
            }
        }
        return dp[ind][target] = Math.max(notPick,pick);
    }
}
