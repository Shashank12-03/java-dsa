package dp;
public class leetcode322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{3},2));
    }
    public static int coinChange(int[] coins, int amount) {
        int[][]dp=new int[coins.length][amount+1];
        
        for (int target = 0; target <= amount; target++) {
            if (target%coins[0]==0) {
                dp[0][target]=target/coins[0];
            }else{
                dp[0][target]= (int) Math.pow(10, 9);
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int target = 0; target <= amount; target++){
                int not_take=dp[i-1] [target];
                int take=(int) Math.pow(10, 9);
                if (coins[i]<=target) {
                    take=1+dp[i][target-coins[i]];
                }
                dp[i][target]=Math.min(not_take, take);
            }
        }
        int ans=dp[coins.length-1][amount];
        if (ans>=(int) Math.pow(10, 9)) {
            return -1;
        }
        else{
            return ans;
        }
    }
    // public static int helper(int index, int[] coins,int amount,int[][]dp) {
    //     if (index==0) {
    //         if (amount%coins[0]==0) {
    //             return amount/coins[0];
    //         }else{
    //             return (int) Math.pow(10, 9);
    //         }
    //     }
    //     if (dp[index][amount]!=-1) {
    //         return dp[index][amount];
    //     }
    //     int not_take=helper(index-1, coins, amount,dp);
    //     int take=(int) Math.pow(10, 9);
    //     if (coins[index]<=amount) {
    //         take=1+helper(index, coins, amount-coins[index],dp);
    //     }
    //     return dp[index][amount]=Math.min(not_take, take);
    // }
}
