package dp;

public class leetcode312 {
    public static void main(String[] args) {
        leetcode312 sol = new leetcode312();
        System.out.println(sol.maxCoins(new int[]{3,1,5,8}));
    }
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length+2];
        newNums[0] =1;
        newNums[newNums.length-1] =1;
        int[][] dp = new int[newNums.length][newNums.length];
        for(int i =0;i<nums.length;i++){
            newNums[i+1] = nums[i];
        }
        for(int i = nums.length ;i>0;i--){
            for(int j = 1;j<=nums.length;j++){
                if(i>j){
                    continue;
                }
                int max = Integer.MIN_VALUE;
                for(int k = i;k<=j;k++){
                    int pnts = newNums[i-1]*newNums[k]*newNums[j+1] + dp[i][k-1] + dp[k+1][j];
                    max = Math.max(max,pnts);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][nums.length];
        // return helper(newNums,1,nums.length,dp);
    }
}
