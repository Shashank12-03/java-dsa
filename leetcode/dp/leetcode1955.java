package dp;

public class leetcode1955 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 0, 0};
        leetcode1955 solution = new leetcode1955();
        int result = solution.countSpecialSubsequences(nums);
        System.out.println("Count of special subsequences: " + result);
    }
    public int countSpecialSubsequences(int[] nums) {
        return helper(0,0,nums);
    }
    private int helper(int i,int curr, int[] nums){
        if(i>=nums.length){
            return 0;
        }
        if(curr==2){
            return 1;
        }
        int notPick = helper(i+1,curr,nums);
        int pick = helper(i+1,curr+1,nums);
        return notPick + pick; 
    }
}
