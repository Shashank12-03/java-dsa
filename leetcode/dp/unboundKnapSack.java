package dp;

// import java.util.Arrays;

public class unboundKnapSack {
    public static void main(String[] args) {
        
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] dp = new int[N][W+1];
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }
        for(int wei =0;wei<=W;wei++){
            dp[0][wei] = (wei/wt[0])*val[0];
        }
        for (int ind = 1;ind<N;ind++){
            for(int weight = 0;weight<=W;weight++){
                int notTake =dp[ind-1][weight]; /*helper(W,ind-1,val,wt,dp);*/
                int take = Integer.MIN_VALUE;
                if(wt[ind]<=weight){
                    take =val[ind] + dp[ind][weight-wt[ind]];  /*helper(W-wt[ind],ind,val,wt,dp);*/
                }
                dp[ind][weight] = Math.max(notTake, take);
            }
        }
        return  dp[N-1][W]; /*helper(W,N-1,val,wt,dp);*/
    }
    // private static int helper(int W,int ind, int val[], int wt[],int[][] dp){
    //     if(ind==0){
    //         return (W/wt[0])*val[0];
    //     }
    //     if (dp[ind][W]!=-1){
    //         return dp[ind][W];
    //     }
    //     int notTake = helper(W,ind-1,val,wt,dp);
    //     int take = Integer.MIN_VALUE;
    //     if(wt[ind]<=W){
    //         take =val[ind] +helper(W-wt[ind],ind,val,wt,dp);
    //     }
    //     return dp[ind][W] = Math.max(take,notTake);
    // }
}
