package dp;

import java.util.Arrays;

public class leetcode887 {
    public static void main(String[] args) {
        leetcode887 sol = new leetcode887();
        System.out.println(sol.stoneGame(new int[]{5,3,4,5}));
    }
    
    // whoever plays first wins the game so alice as here always place first she will win so just return true
    
    public boolean stoneGame(int[] piles) {
        int total = 0;
        for(int pile:piles){
            total+=pile;
        } 
        int n = piles.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        int alice = helper(piles.length-1,0,1,piles,n,dp);
        total = total/2;
        return total<alice;
    }

    private int helper(int i,int j, int alice,int[] piles,int n,int[][] dp){
        if(i<0 || j>=n){
            return 0;
        }
        if (dp[i][j]!=-1) {
            return dp[i][j];
        }
        if (i==j) {
            return dp[i][j] = alice==1?piles[i]:0;
        }

        if (alice==1){
            return dp[i][j] = Math.max(piles[i]+helper(i-1,j,0,piles,n,dp),piles[j]+helper(i,j+1,0,piles,n,dp)); 
        }
        return dp[i][j] = Math.min(helper(i-1,j,1,piles,n,dp),helper(i,j+1,1,piles,n,dp)); 
    }
}
