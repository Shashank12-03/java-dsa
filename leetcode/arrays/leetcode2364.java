package arrays;

import java.util.HashMap;
import java.util.Map;

public class leetcode2364 {
    public static void main(String[] args) {
        leetcode2364 solution = new leetcode2364();
        int[] nums = {4, 1, 3, 3};
        long result = solution.countBadPairs(nums);
        System.out.println("Number of bad pairs: " + result);
    }
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2;
        Map<Integer, Integer> map = new HashMap<>();
        long goodPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;
            if (map.containsKey(key)) {
                goodPairs += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return totalPairs - goodPairs;
    }
}
