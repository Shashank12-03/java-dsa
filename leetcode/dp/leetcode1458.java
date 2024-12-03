package dp;

import java.util.Arrays;

public class leetcode1458 {
    public static void main(String[] args) {
        leetcode1458 sol = new leetcode1458();
        System.out.println(sol.maxDotProduct(new int[]{-3,-8,3,-10,1,3,9}, new int[]{9,2,3,7,-9,1,-8,5,-1,-1}));
    }
    public int maxDotProductTab(int[] nums1, int[] nums2) {
        int n=  nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        dp[0][0] = nums1[0]*nums2[0];
        for (int i = 1; i <n; i++){
            dp[i][0] = Math.max(dp[i-1][0], nums1[i]*nums2[0]);
        }
        for (int i = 1; i <m; i++){
            dp[0][i] = Math.max(dp[0][i-1], nums1[0]*nums2[i]);
        }
        for (int i = 1; i <n; i++) {
            for (int j = 1; j < m; j++) {
                int notPick = Math.max(dp[i][j-1],dp[i-1][j]);
                int pick = nums1[i]*nums2[j] + dp[i-1][j-1];
                dp[i][j] =  Math.max(nums1[i]*nums2[j], Math.max(pick,notPick)); 
            }
        }
        return dp[n-1][m-1];
    }
    
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n=  nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return helper(n-1,m-1,nums1,nums2,true,dp);
    }
    
    private int helper(int i, int j, int[] nums1, int[] nums2,boolean flag,int[][] dp){
        if (i<0 || j<0){
            if (flag){
                return 0;
            }else{
                return Integer.MIN_VALUE;
            }
        }
        if(dp[i][j]!=Integer.MIN_VALUE){
            return dp[i][j];
        }
        int notPick = Math.max(helper(i,j-1,nums1,nums2,false,dp),helper(i-1,j,nums1,nums2,false,dp));
        int pick = nums1[i]*nums2[j] + helper(i-1,j-1,nums1,nums2,true,dp);
        int ans =Math.max(nums1[i]*nums2[j], Math.max(pick,notPick));
        return dp[i][j] =  ans; 
    }
}
