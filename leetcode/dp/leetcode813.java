package dp;

// import java.util.Arrays;

/**
 * leetcode813
 */
public class leetcode813 {
    public static void main(String[] args) {
        leetcode813 sol = new leetcode813();
        System.out.println(sol.largestSumOfAverages(new int[]{9,1,2,3,9}, 3));
    }
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][] dp = new double[n+1][k+1];
        for(int i =0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int ind = n-1;ind>=0;ind--){
            for(int j = 1;j<=k;j++){
                double maxAvg = 0;
                int sum = 0;
                int len = 0;
                for(int i = ind;i<nums.length;i++){
                    len++;
                    sum+=nums[i];
                    double avg = ((double) sum / len) +dp[i+1][j-1];
                    maxAvg = Math.max(avg,maxAvg);
                }
                dp[ind][j] = maxAvg;
            }
        }
        return dp[0][k];
        // return helper(nums,k,0,dp);
    }
    // private double helper(int[] nums, int k,int ind,double[][] dp){
    //     if(ind==nums.length){
    //         return 0;
    //     }
    //     if (dp[ind][k]!=-1.0) {
    //         return dp[ind][k];
    //     }
    //     if (k==0) {
    //         return Double.NEGATIVE_INFINITY;
    //     }
    //     double maxAvg = 0;
    //     int sum = 0;
    //     int len = 0;
    //     for(int i = ind;i<nums.length;i++){
    //         len++;
    //         sum+=nums[i];
    //         double avg = ((double) sum / len) + helper(nums,k-1,i+1,dp);
    //         maxAvg = Math.max(avg,maxAvg);
    //     }
    //     return dp[ind][k] = maxAvg;
    // }
}