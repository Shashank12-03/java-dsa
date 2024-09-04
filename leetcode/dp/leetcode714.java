package dp;

// import java.util.Arrays;

public class leetcode714 {
    public static void main(String[] args) {
        
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        // for(int[] arr:dp){
        //     Arrays.fill(arr, -1);
        // }
        for (int ind = 0; ind < dp.length; ind++) {
            for (int buy = 0; buy < dp[0].length; buy++) {
                if(buy==1){
                    dp[ind][buy] = Math.max(-prices[ind]+dp[ind+1][0],dp[ind+1][1]);
                }else{
                    dp[ind][buy] = Math.max(prices[ind]+dp[ind+1][1]-fee,dp[ind+1][0]);
                }
            }
        }
        return dp[n][1];
    }

    // private int helper(int[] prices,int fee,int ind,int buy,int[][] dp){
    //     if(ind==prices.length){
    //         return 0;
    //     }
    //     if (dp[ind][buy]!=-1){
    //         return dp[ind][buy];
    //     }
    //     if(buy==1){
    //         return dp[ind][buy] = Math.max(-prices[ind]+helper(prices,fee,ind+1,0,dp),helper(prices,fee,ind+1,1,dp));
    //     }else{
    //         return dp[ind][buy] = Math.max(prices[ind]+helper(prices,fee,ind+1,1,dp)-fee,helper(prices,fee,ind+1,0,dp));
    //     }
    // }
    
}
