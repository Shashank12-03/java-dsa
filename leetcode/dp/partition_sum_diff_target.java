package dp;
// import java.util.*;
public class partition_sum_diff_target {
    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{5,2,6,4}, 3));
    }
    static int countPartitions(int[] nums, int target){
        int  totSum = 0;
        for(int i=0; i<nums.length;i++){
            totSum +=nums[i];
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
    // private static int helper(int ind, int target, int[] nums, int[][] dp) {
    //     if (ind==0) {
    //         if(target==0 && nums[0]==0 ){
    //             return 2;
    //         }
    //         if (target==0 && nums[0]==target) {
    //             return 1;
    //         }
    //         return 0;
    //     }
    //     if(dp[ind][target]!=-1){
    //         return dp[ind][target];
    //     }
    //     int not_take=helper(ind-1, target, nums, dp);
    //     int take=0;
    //     if(nums[ind]<=target){
    //         take=helper(ind-1, target-nums[ind], nums, dp);
    //     }
    //     return dp[ind][target]=take+not_take;
    // }
}
