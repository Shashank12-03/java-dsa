package dp;

import java.util.Arrays;

/**
 * leetcode1547
 */
public class leetcode1547 {

    public static void main(String[] args) {
        
    }
    public int minCostTab(int n, int[] cuts) {
        int[] newCut = new int[cuts.length+2];
        int[][] dp = new int[newCut.length][newCut.length];
        newCut[0] = 0;
        newCut[newCut.length-1]  = n;
        for(int i =0;i<cuts.length;i++){
            newCut[i+1] = cuts[i];
        }
        Arrays.sort(newCut);
        for (int i = n; i >0; i--) {
            for (int j = 1; j <=n ; j++) {
                if(i>j){
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(int k = i;k<=j;k++){
                    int cost = cuts[j+1]-cuts[i-1] + dp[i][k-1] +dp[k+1][j];
                    min = Math.min(cost,min);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][cuts.length];
    }

    public int minCost(int n, int[] cuts) {
        int[] newCut = new int[cuts.length+2];
        int[][] dp = new int[newCut.length][newCut.length];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        newCut[0] = 0;
        newCut[newCut.length-1]  = n;
        for(int i =0;i<cuts.length;i++){
            newCut[i+1] = cuts[i];
        }
        Arrays.sort(newCut);
        return helper(1,cuts.length,newCut,dp);
    }
    private int helper(int i,int j, int[] cuts,int[][] dp){
        if (i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i;k<=j;k++){
            int cost = cuts[j+1]-cuts[i-1] + helper(i,k-1,cuts,dp) + helper(k+1,j,cuts,dp);
            min = Math.min(cost,min);
        }
        return dp[i][j] = min;
    }
}