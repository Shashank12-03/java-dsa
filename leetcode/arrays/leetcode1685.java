package arrays;

import java.util.Arrays;

public class leetcode1685 {
    public static void main(String[] args) {
        leetcode1685 sol = new leetcode1685();
        System.out.println(Arrays.toString(sol.getSumAbsoluteDifferences(new int[]{2,3,5})));
    }
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i];
        } 
        for(int i = 0;i<n;i++){
            ans[i] = (((i+1)*nums[i])-prefix[i]) + (prefix[n-1]-prefix[i]-((n-(i+1))*nums[i]));
        }
        return ans;
    }
}
