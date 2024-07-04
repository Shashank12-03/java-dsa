package greedy;

import java.util.Arrays;

public class leetcode1509 {
    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{1,5,0,10,14}));
    }
    public static int minDifference(int[] nums) {
        if(nums.length<5){
            return 0;
        }else{
            int n = nums.length;
            Arrays.sort(nums);
            int a = nums[n-4]-nums[0];
            int b = nums[n-3]-nums[1];
            int c = nums[n-2]-nums[2];
            int d = nums[n-1]-nums[3];
            return Math.min(Math.min(a, b),Math.min(c,d));
        }
        
    }
}