package dp;

// import java.util.Arrays;

public class leetcode873 {
    public static void main(String[] args) {
        leetcode873 sol = new leetcode873();
        System.out.println(sol.lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
    }
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int result = 0;
        int[][] dp = new int[n][n];

        for (int i = 2; i < n; i++) {
            int l = 0, r = i - 1;

            while (l < r) {
                int sum = arr[l] + arr[r];
                // System.out.println(sum);
                if (sum > arr[i]) {
                    r--;
                } else if (sum < arr[i]) {
                    l++;
                } else {
                    // System.out.println(dp[l][r]);
                    dp[r][i] = dp[l][r] + 1;
                    // System.out.println(dp[r][i]);
                    result = Math.max(result, dp[r][i]);
                    l++;
                    r--;
                }
            }
        }

        if (result != 0) {
            return result + 2;
        }

        return 0;
    }

    // public int lenLongestFibSubseq(int[] arr) {
    //     int[][] dp = new int[arr.length+1][arr.length+1];
    //     int maxLen = 0;
    //     for(int[]num:dp){
    //         Arrays.fill(num,-1);
    //     }
    //     for(int i =0;i<arr.length;i++){
    //         for(int j =i+1;j<arr.length;j++){
    //             int len = helper(i,j,arr,dp);
    //             if(len>0){
    //                 maxLen = Math.max(len+2,maxLen);
    //             }
    //         }
    //     }
    //     return maxLen;
    // }
    // private int helper(int i , int j,int[] arr,int[][]dp){
    //     int cnt = 0;
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     for(int k = j+1;k<arr.length;k++){
    //         if (arr[i]+arr[j]==arr[k]){
    //             cnt = 1+ helper(j,k,arr,dp);
    //             break;
    //         }
    //     }
    //     return dp[i][j] = cnt;
    // }

}
