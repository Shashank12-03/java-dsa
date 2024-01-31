package dp;

public class leetcode416 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{2,2,3,5}));
    }
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for (int i : nums) {
            sum+=i;
        }
        if(sum%2==1){
            return false;
        }
        return subset_sum(nums, sum/2);
    }
    public static boolean subset_sum(int[] nums,int target){
        //recurrison_helper(nums,target,nums.length-1);
        // int[][]dp= new int[nums.length][target+1];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        // return memorization_helper(nums, target, nums.length-1, dp);
        //tabulation
        boolean[][] dp = new boolean[nums.length][target+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0]=true;
        }
        if(nums[0] <= target){
            dp[0][nums[0]]=true;
        }
        for (int ind = 1; ind < nums.length; ind++) {
            for (int tar = 1; tar <=target; tar++) {
                boolean not_take=dp[ind-1][tar];
                boolean take=false;
                if(tar>=nums[ind]){
                    take=dp[ind-1][tar-nums[ind]];
                }
                dp[ind][tar]=take||not_take;
            }
        }
        return dp[nums.length-1][target];
        //space optimize
        // boolean[]prev = new boolean[target+1];
        // boolean[]curr = new boolean[target+1];
        // prev[0]=curr[0]=true;
        // if (nums[0]<=target) {
        //     prev[nums[0]]=true;
        // }
        
        // for (int ind = 1; ind < nums.length; ind++) {
        //     for (int tar = 1; tar <=target; tar++) {
        //         boolean not_take=prev[tar];
        //         boolean take=false;
        //         if(tar>=nums[ind]){
        //             take=prev[tar-nums[ind]];
        //         }
        //         curr[tar]=take||not_take;
        //     }
        //     prev=curr;
        // }
        // return prev[target];
        
    }
}
