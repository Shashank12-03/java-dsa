package dp;
public class leetcode55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
    public static boolean canJump(int[] nums) {
        // boolean[]dp=new boolean[nums.length+1];
        // dp[0] = true;
        // return helper(nums.length-1,nums ,dp);
        boolean[] dp = new boolean[nums.length];
        dp[0] = true; // We can always reach the first index
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break; // Once we found a reachable index, we don't need to check further
                }
            }
        }
    
        return dp[nums.length - 1]; 
    }
    // private static boolean helper(int index, int[] nums, boolean[] dp) {
    //     if (dp[index]) {
    //         return true; // If we have already visited this index and marked it as reachable, return true
    //     }
    
    //     for (int i = index - 1; i >= 0; i--) { // Check from the current index backwards
    //         if (i + nums[i] >= index) { // If we can jump from i to index
    //             if (helper(i, nums, dp)) { // Recursively check if we can reach index from i
    //                 dp[index] = true; // Mark index as reachable
    //                 return true;
    //             }
    //         }
    //     }
    
    //     return false;
    // }
}
