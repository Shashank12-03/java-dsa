package dp;


public class leetcode2466 {
    public static void main(String[] args) {
        leetcode2466 solution = new leetcode2466();
        int result = solution.countGoodStrings(2, 3, 1, 2);
        int resul2 = solution.countGoodStrings(3, 3, 1, 1);

        System.out.println("Result: " + result + " " + resul2);
    }

    int mod;
    public int countGoodStrings(int low, int high, int zero, int one) {
        mod = 1000000007;
        // int[] dp1 = new int[low+1];
        // dp1[0] = 1;
        // for (int i = 1; i <=low; i++) {
        //     dp1[i] +=  (((i-one>=0?dp1[i-one]:1) + (i-zero>=0?dp1[i-zero]:1))%mod)%mod;
        // }
        // int lower = (dp1[low] % mod + mod) % mod;
        // System.out.println(Arrays.toString(dp1));
        int[] dp = new int[high+2];
        dp[0] = 1;
        for (int i = 1; i <=high+1; i++) {
            dp[i] +=  (((i-one>=0?dp[i-one]:1) + (i-zero>=0?dp[i-zero]:1))%mod)%mod;
        }
        return ((dp[high + 1] - dp[low] + mod) % mod + mod) % mod;
    }
    // private int helper(int limit, int zero, int one,int ans,int[] dp){
    //     if (limit<=0){
    //         return 1;
    //     }
    //     if(dp[limit]!=-1){
    //         return dp[limit]%mod;
    //     }
    //     ans += helper(limit-one,zero,one,ans,dp) + helper(limit-zero,zero,one,ans,dp);
    //     return  dp[limit] = (ans % mod)%mod;
    // }
}
