package dp;


import java.util.*;
/**
 * leetcode1130
 */
public class leetcode1130 {

    public static void main(String[] args) {
        leetcode1130 sol = new leetcode1130();
        System.out.println(sol.mctFromLeafValues(new int[]{6,2,4}));
    }
    
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int[] num:dp){
            Arrays.fill(num, -1);
        }
        return helper(0,arr.length-1,arr,dp);
    }
    private int helper(int i, int j, int[] arr,int[][] dp) {
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int max1 = findMax(arr,i, k);
            int max2 = findMax(arr,k+1,j);
            int prod = max1*max2;
            mini =Math.min( prod + helper(i, k, arr,dp) + helper(k+1, j, arr,dp),mini);
        } 
        return dp[i][j] = mini;
    }
    private int findMax(int[] arr, int i, int j) {
        int maxVal = arr[i];
        for (int k = i + 1; k <= j; k++) {
            maxVal = Math.max(maxVal, arr[k]);
        }
        return maxVal;
    }
}