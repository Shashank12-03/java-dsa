package dp;

import java.util.*;

public class printLIS {
    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(8, new int[]{10,9,2,5,3,7,101,18}));
    }
    public static ArrayList<Integer> longestIncreasingSubsequence(int n, int[] nums) {
        // Code here
        // int n = nums.length;
        // int[] curr = new int[n+1];
        int[] dp = new int[n];
        int[] hash = new int[n];
        // int[][] dp = new int[n+1][n+1];
        Arrays.fill(dp,1);
        Arrays.fill(hash,1);
        // for(int i =0;i<n;i++){
        //     dp[n-1][i] = 0;
        // }
        int max = -1;
        int lastIndex = -1;
        for(int i =0;i<n;i++){
            hash[i] = i;
            for(int j =0;j<i;j++){
                // int notTake =next[j+1]; /*helper(nums,prev,ind+1,dp);*/
                // int take = 0;
                if(nums[j]<nums[i] && 1+dp[j]>dp[i]){
                    dp[i] =1+dp[j]; /*helper(nums,ind,ind+1,dp);*/
                    hash[i] = j;
                }
            }
            
        }
        for (int i = 0; i <n; i++) {
            if (dp[i]>max){
                max = dp[i];
                lastIndex = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);
        while (hash[lastIndex]!=lastIndex) {
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }
        Collections.reverse(list);
        return list; /*helper(nums,-1,0,dp);*/
    }
}