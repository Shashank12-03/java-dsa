package arrays;

import java.util.*;

public class leetcode719 {
    public static void main(String[] args) {
        leetcode719 sol = new leetcode719();
        System.out.println(sol.smallestDistancePair(new int[]{10, 20, 30, 40, 50}, 6));
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];
        
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0, left = 0;
            
            for (int right = 0; right < nums.length; right++) {
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                count += right - left;
            }
            
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}
