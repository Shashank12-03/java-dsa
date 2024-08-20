package dp;

// import java.util.*;

public class perfectSum {
    public static void main(String[] args) {
        perfectSum sol = new perfectSum();
        System.out.println(sol.perfectsum(new int[]{9,7,0,3,9,8,6,5,7,6},10,31));
    }
    public int perfectsum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
        int mod = 1000000007;
        int[][] dp =new int[n][sum+1];
	    // for(int[] num:dp){
	    //         Arrays.fill(num,-1);
	    // }
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        if(arr[0]<=sum){
            dp[0][arr[0]]=1;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target= 0; target <= sum; target++) {
                int notTake = dp[ind-1][target];/*helper(arr,ind-1,sum,dp,mod);*/
                int take = 0;
                if(arr[ind]<=sum){
                    take =dp[ind-1][target-arr[ind]]; /*helper(arr,ind-1,sum-arr[ind],dp,mod);*/
                }
                dp[ind][target] = (take+notTake)%mod;
            }
        }
	    // return helper(arr,n-1,sum,dp,mod);
        return dp[n-1][sum];
	} 
	// private int helper(int arr[],int ind, int sum,int[][]dp,int mod){
	//     if (sum==0){
	//         return 1;
	//     }
	//     if(ind==0){
	//         return arr[0]==sum?1:0;
	//     }
	//     if(dp[ind][sum]!=-1){
	//         return dp[ind][sum];
	//     }
	//     int notTake = helper(arr,ind-1,sum,dp,mod);
	//     int take = 0;
	//     if(arr[ind]<=sum){
	//         take = helper(arr,ind-1,sum-arr[ind],dp,mod);
	//     }
	//     return dp[ind][sum] = (take+notTake)%mod;
	// }
}
