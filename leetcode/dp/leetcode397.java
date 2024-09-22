package dp;

public class leetcode397 {
    public static void main(String[] args) {
        
    }
    public long integerReplacement(long n) {
        long [] dp = new long[(int) (n+1)];
        dp[1] = 0;
        // Arrays.fill(dp,-1);
        for(int i = 2;i<n+1;i++){
            if(i%2==0){
                dp[i] = 1+dp[i/2];
            }else{
                dp[i] = 1 + Math.min(dp[i - 1], dp[(i + 1) / 2] + 1);
            }
        }
        return  dp[(int) n]; /*count(n,dp);*/
    }
    // private int count(int n,int[] dp){
    //     if(n==1){
    //         return 0;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     // int evenCnt = 0;
    //     if (n%2 ==0){
    //         return dp[n] = 1+ count(n/2,dp);
    //     }
    //     else{
    //         return dp[n] = Math.min(1+count(n-1,dp),1+count(n+1,dp));
    //     }
    //     // return Math.min(evenCnt,oddCnt);
    // }
    
}
