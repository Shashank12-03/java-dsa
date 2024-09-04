package dp;

/**
 * leetcode188
 */
public class leetcode188 {

    public static void main(String[] args) {
        
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int ind =n-1;ind>=0;ind--){
            for(int buy=0;buy<2;buy++){
                for(int cap = 1;cap<=k;cap++){
                    if(buy==1){
                        dp[ind][buy][cap] = Math.max(-prices[ind]+dp[ind+1][0][cap],dp[ind+1][1][cap]);
                    }else{
                        dp[ind][buy][cap] = Math.max(prices[ind]+dp[ind+1][1][cap-1],dp[ind+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
        // for(int[][] arr:dp){
        //     for(int[] num:arr){
        //         Arrays.fill(num, -1);
        //     }
        // }
        // return helper(prices,0,1,k,dp);
    }
    // private int helper(int[] prices,int ind,int buy,int cap,int[][][] dp){
    //     if (cap==0){
    //         return 0;
    //     }
    //     if(ind==prices.length){
    //         return 0;
    //     }
    //     if (dp[ind][buy][cap]!=-1){
    //         return dp[ind][buy][cap];
    //     }
    //     if(buy==1){
    //         return dp[ind][buy][cap] = Math.max(-prices[ind]+helper(prices,ind+1,0,cap,dp),helper(prices,ind+1,1,cap,dp));
    //     }else{
    //         return dp[ind][buy][cap] = Math.max(prices[ind]+helper(prices,ind+1,1,cap-1,dp),helper(prices,ind+1,0,cap,dp));
    //     }
    // }
}