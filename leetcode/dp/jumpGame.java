package dp;

import java.util.*;

public class jumpGame {
    public static void main(String[] args) {
        jumpGame sol = new jumpGame();
        // System.out.println(sol.minimizeCost(new int[]{10, 30, 40, 50, 20}, 3));
        System.out.println(sol.minimizeCostTab(new int[]{10, 30, 40, 50, 20}, 3));
    }
    public int minimizeCostTab(int arr[], int k) {
        // code here
        // return helper(arr,k,arr.length-1);
        // int[] dp =new int[arr.length+1];
        // Arrays.fill(dp,10001);
        // dp[0]=arr[0];
        // for(int i= 0;i<arr.length;i++){
        //     // int min =10001;
        //     for(int j =1;j<=k;j++){
        //         if(i-j>=0){
        //             int value = dp[i-j]+Math.abs(arr[i]-arr[i-j]);
        //             dp[i] = Math.min(dp[i],value);
        //         }
        //     }
        // }
        // return dp[arr.length];
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;  // or some base case value

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(arr[i] - arr[i - j]));
                }
            }
        }

        return dp[n - 1];
    }
    public int minimizeCostMemo(int arr[], int k) {
        // code here
        // return helper(arr,k,arr.length-1);
        int[] dp =new int[arr.length+1];
        Arrays.fill(dp,-1);
        return helper(arr,k,arr.length-1,dp);
    }
    public int helper(int[] arr,int k ,int ind){
        if(ind==0){
            return 0;
        }
        int min =10001;
        for(int i=1;i<=k;i++){
            if(ind-i>=0){
                int value = helper(arr,k,ind-i)+Math.abs(arr[ind]-arr[ind-i]);
                min = Math.min(min,value);
            }
        }
        return min;
    }
    public int helper(int[] arr,int k ,int ind,int[]dp){
        if(ind==0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int min =10001;
        for(int i=1;i<=k;i++){
            if(ind-i>=0){
                int value = helper(arr,k,ind-i,dp)+Math.abs(arr[ind]-arr[ind-i]);
                min = Math.min(min,value);
            }
        }
        return dp[ind]=min;
    }
}
