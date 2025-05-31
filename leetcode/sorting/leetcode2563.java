package sorting;

import java.util.Arrays;

public class leetcode2563 {
    public static void main(String[] args) {
        int[] nums = {0,1,7,4,4,5};
        // 0 1 4 4 5 7
        int lower = 3;
        int upper = 6;
        leetcode2563 obj = new leetcode2563();
        long result = obj.countFairPairs(nums, lower, upper);
        System.out.println("Number of fair pairs: " + result);
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);
        // 0 1 4 4 5 7
        for(int i = 0;i<nums.length;i++){
            int lowerBound = lower - nums[i];
            int higherBound = upper - nums[i];
            int lowerIndex = findLowerBound(nums,lowerBound,i+1);
            int higherIndex = findUpperBound(nums,higherBound,i+1);
            ans += (higherIndex-lowerIndex);
        }
        return ans;
    }
    private int findLowerBound(int[] nums, int target, int start) {
        int low = start;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int findUpperBound(int[] nums, int target, int start) {
        int low = start;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
