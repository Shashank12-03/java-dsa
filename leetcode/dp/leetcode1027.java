package dp;

import java.util.*;

public class leetcode1027 {
    public static void main(String[] args) {
        leetcode1027 sol = new leetcode1027();
        System.out.println(sol.longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }
    public int longestArithSeqLength(int[] nums) {
        if (nums.length<3) {
            return 0;
        }
        int ans =0;
        System.out.println(Arrays.stream(nums).max().getAsInt());
        // Arrays.stream(nums).min();
        for (int i =0; i <nums.length; i++) {
            for (int j =i+1; j<nums.length; j++) {
                ans = Math.max(ans,2 + helper(i,nums[i]-nums[j],nums));
            }
        }
        return ans;
    }
    private int helper(int ind,int diff,int[]nums){
        if(ind<0){
            return 0;
        }
        int ans = 0;
        for (int i = ind-1; i>=0; i--) {
            if (nums[ind]-nums[i]==diff) {
                ans = Math.max(ans, 1 + helper(i, diff, nums));
            }
        }
        return ans;
    }
}
