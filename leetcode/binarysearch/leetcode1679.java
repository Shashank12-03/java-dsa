package binarysearch;

import java.util.Arrays;

public class leetcode1679 {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1,2,3,4}, 5));
    }
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int st = 0;
        int en = nums.length-1;
        int count = 0;
        
        while (st<en) {
            int sum = nums[st]+nums[en];
            if(sum==k){
                count++;
                st++;
                en--;
            }
            if (sum<k) {
                st++;
            }
            if (sum>k){
                en--;
            }
            sum = 0;
        }
        return count;
    }
}
