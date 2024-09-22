package dp;

import java.util.*;

public class leetcode1043 {
    public static void main(String[] args) {
        
    }
    public int maxSumAfterPartitioningTab(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        for (int i = n-1; i>=0; i--) {
            int maxSum = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            int len = 0;
            for(int j = i;j<Math.min(arr.length,i+k);j++){
                len++;
                max = Math.max(max,arr[j]);
                int sum = len*max +dp[j+1]; /*helper(arr,i+1,k,dp);*/
                maxSum = Math.max(maxSum,sum);
            }
            dp[i] = maxSum;
        }
        return dp[0];/*helper(arr,0,k,dp);*/
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(arr,0,k,dp);
    }
    private int helper(int[] arr,int ind, int k,int[] dp){
        if (ind==arr.length){
            return 0;
        }
        if (dp[ind]!=-1) {
            return dp[ind];
        }
        int maxSum = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int len = 0;
        for(int i = ind;i<Math.min(arr.length,ind+k);i++){
            len++;
            max = Math.max(max,arr[i]);
            int sum = len*max + helper(arr,i+1,k,dp);
            maxSum = Math.max(maxSum,sum);
        }
        return dp[ind] = maxSum;
    }
}
