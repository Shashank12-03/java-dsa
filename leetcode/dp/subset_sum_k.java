package dp;
// import java.util.*;
public class subset_sum_k {
    public static void main(String[] args) {
        System.out.println(subset_sum(new int[]{1,2,3,5}, 4));
    }
    public static boolean subset_sum(int[] nums,int target){
        //recurrison_helper(nums,target,nums.length-1);
        // int[][]dp= new int[nums.length][target+1];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        // return memorization_helper(nums, target, nums.length-1, dp);
        //tabulation
        // boolean[][] dp = new boolean[nums.length][target+1];
        // for (int i = 0; i < nums.length; i++) {
        //     dp[i][0]=true;
        // }
        // if(nums[0] <= target){
        //     dp[0][nums[0]]=true;
        // }
        // for (int ind = 1; ind < nums.length; ind++) {
        //     for (int tar = 1; tar <=target; tar++) {
        //         boolean not_take=dp[ind-1][tar];
        //         boolean take=false;
        //         if(tar>=nums[ind]){
        //             take=dp[ind-1][tar-nums[ind]];
        //         }
        //         dp[ind][tar]=take||not_take;
        //     }
        // }
        // return dp[nums.length-1][target];
        //space optimize
        boolean[]prev = new boolean[target+1];
        boolean[]curr = new boolean[target+1];
        prev[0]=curr[0]=true;
        prev[nums[0]]=true;
        for (int ind = 1; ind < nums.length; ind++) {
            for (int tar = 1; tar <=target; tar++) {
                boolean not_take=prev[tar];
                boolean take=false;
                if(tar>=nums[ind]){
                    take=prev[tar-nums[ind]];
                }
                curr[tar]=take||not_take;
            }
            prev=curr;
        }
        return prev[target];
        
    }
    // private static boolean recurrison_helper(int[] nums,int target,int index){
    //     if (target==0) {
    //         return true;
    //     }
    //     if(index==0){
    //         return nums[0]==target;
    //     }
    //     boolean not_take= recurrison_helper(nums,target,index-1);
    //     boolean take=true;
    //     if(target>=nums[index]){
    //         take= recurrison_helper(nums, target-nums[index], index-1);
    //     }
    //     return take||not_take;
    // }
    // private static boolean memorization_helper(int[] nums,int target,int index,int[][]dp){
    //     if (target==0) {
    //         return true;
    //     }
    //     if(index==0){
    //         return nums[0]==target;
    //     }
    //     if(dp[index][target]!=-1){
    //         return dp[index][target] == 0 ? false : true;
            
    //     }
    //     boolean not_take= memorization_helper(nums,target,index-1,dp);
    //     boolean take=false;
    //     if(target>=nums[index]){
    //         take= memorization_helper(nums, target-nums[index], index-1,dp);
    //     }
    //     dp[index][target] = not_take || take ? 1 : 0;
    //     return not_take || take;
    // }
}
