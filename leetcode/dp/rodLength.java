package dp;

// import java.util.Arrays;

public class rodLength {
    public static void main(String[] args) {
        
    }
    public int cutRod(int price[], int n) {
        //code here  
        int[][] dp = new int[n][n+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }
        for(int len =0;len<=n;len++){
            dp[0][len] = len*price[0];
        }
        for(int ind = 1;ind<n;ind++){
            for (int len = 0; len <= n; len++) {
                int notBreak = dp[ind-1][len]; /*helper(price,n,ind-1,dp);*/
                int Break = Integer.MIN_VALUE;
                if(ind+1<=len){
                    Break = price[ind]+ dp[ind][len-(ind+1)]; /*helper(price,n-(ind+1),ind,dp);*/
                }
                dp[ind][len] = Math.max(Break,notBreak);
            }
        }
        return dp[n-1][n];
        // return helper(price, n, n-1,dp);
    }
    // private int helper(int price[],int n, int ind,int[][] dp){
    //     if(ind==0){
    //         return n*price[ind];
    //     }
    //     if (dp[ind][n]!=-1){
    //         return dp[ind][n];
    //     }
    //     int notBreak = helper(price,n,ind-1,dp);
    //     int Break = Integer.MIN_VALUE;
    //     if(ind+1<=n){
    //         Break = price[ind]+ helper(price,n-(ind+1),ind,dp);
    //     }
    //     return dp[ind][n] = Math.max(Break,notBreak);
    // }
}
