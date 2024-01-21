package arrays;
public class leetcode198 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
    public static int rob(int[] nums) {
        if (nums.length==1) {
            return nums[0];
        }
        //int[] dp=new int[nums.length];
        int current=nums[0];//dp[0]=nums[0];
        int previous=0;//dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 1; i < nums.length; i++) {
            int pick=nums[i];
            if(i>1){
                pick+=previous;
            }
            int notpick=current;
            int curr=Math.max(pick, notpick);
            previous=current;
            current=curr;
            //dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return current;
        // return dp[dp.length-1];
        // Arrays.fill(dp, -1);
        // return helper(nums,dp,nums.length-1);
    }
    // private static int helper(int[] nums,int[] dp, int index) {
    //     if(index==0){
    //         return nums[index];
    //     }
    //     if (index<0) {
    //         return 0;
    //     }
    //     if(dp[index]!=-1){
    //         return dp[index];
    //     }
    //     int pick=nums[index]+helper(nums,dp, index-2);
    //     int notpick=0+helper(nums,dp,index-1);
    //     return dp[index]=Math.max(pick, notpick);
    // }
    
}
