package slidingwindow;

import java.util.*;

public class leetcode1695 {
    public static void main(String[] args) {
        leetcode1695 sol = new leetcode1695();
        System.out.println(sol.maximumUniqueSubarray(new int[] { 187, 470, 25, 436, 538, 809, 441, 167, 477, 110, 275,
                133, 666, 345, 411, 459, 490, 266, 987, 965, 429, 166, 809, 340, 467, 318, 125, 165, 809, 610, 31, 585,
                970, 306, 42, 189, 169, 743, 78, 810, 70, 382, 367, 490, 787, 670, 476, 278, 775, 673, 299, 19, 893,
                817, 971, 458, 409, 886, 434 }));
    }

    public int maximumUniqueSubarray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] freq = new int[max + 1];
        int maxSum = 0;
        int sum = 0;
        // 0 0 1 0 2 1 1
        // 4,2,4,5,6
        for (int i = 0; i < nums.length; i++) {
            if (freq[nums[i]] == 0) {
                sum += nums[i];
                // 0 0 1 0 1 1 0
                freq[nums[i]]++;
            }
            else if (freq[nums[i]] > 1) {
                sum = 0;
                freq[nums[i]] =1;
            }
            System.out.println(Arrays.toString(freq));
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
