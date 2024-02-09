package dp;

public class leetcode494 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums, target);
    }
    static int countPartitions(int[] nums, int target){
        int totSum = 0;
        for(int i=0; i<nums.length;i++){
            totSum += nums[i];
        }
        
        //Checking for edge cases
        if(totSum-target <0 || (totSum-target)%2==1 ) return 0;
        
        return count_partition_sum_diff_target(nums,(totSum-target)/2);
    }
    
    public static int count_partition_sum_diff_target(int[]nums,int target){
        int[][]dp=new int[nums.length][target+1];
        if (nums[0]==0) {
            dp[0][0]=2;
        }
        else{
            dp[0][0]=1;
        }
        if (nums[0]!=0 && nums[0]<=target) {
            dp[0][nums[0]]=1;
        }
        for (int ind = 1; ind < nums.length; ind++) {
            for (int tar = 0; tar <= target; tar++) {
                int not_take=dp[ind-1][tar];
                int take=0;
                if(nums[ind]<=tar){
                    take=dp[ind-1][tar-nums[ind]];
                }
                dp[ind][tar]=take+not_take;
            }
        }
        return dp[nums.length-1][target];
        //return helper(nums.length-1,target,nums,dp);
    }
}
