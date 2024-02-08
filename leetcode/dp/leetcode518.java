package dp;
import java.util.*;
public class leetcode518 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
    }
    public static int coinChange(int[] coins, int amount) {
        int[][]dp=new int[coins.length][amount+1];
        
        for (int[] is : dp) {
            Arrays.fill(is,-1);
        }
        return helper(coins.length-1,amount,coins,dp);
    }
    private static int helper(int index, int amount, int[] coins,int[][]dp) {
        if (index==0) {
            if(amount%coins[0]==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        int not_take=helper(index-1, amount, coins,dp);
        int take=0;
        if (coins[index]<=amount) {
            take=helper(index, amount-coins[index], coins,dp);
        }
        return dp[index][amount]=take+not_take;
    }
    
}
