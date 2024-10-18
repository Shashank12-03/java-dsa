package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class leetcode1497 {
    public static void main(String[] args) {
        leetcode1497 sol = new leetcode1497();
        System.out.println(sol.canArrange(new int[]{-1,1,-2,2,-3,3,-4,4}, 3));
    }
    public boolean canArrange(int[] arr, int k) {
        if (arr.length == 2) {
            return (arr[0] + arr[1]) % k == 0;
        }

        // Map to store frequency of remainders
        Map<Integer, Integer> remainderMap = new HashMap<>();
        
        // Calculate remainder frequencies
        for (int num : arr) {
            int remainder = ((num % k) + k) % k; // Ensure positive remainder
            remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0) + 1);
        }

        // Check pairs
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            int complement = (k - remainder) % k;

            if (remainder == 0) {
                // Remainder 0 must have an even count (self-pairing)
                if (remainderMap.get(remainder) % 2 != 0) {
                    return false;
                }
            } else if (remainder == complement) {
                // For k/2 remainder, it must have an even count (self-pairing)
                if (remainderMap.get(remainder) % 2 != 0) {
                    return false;
                }
            } else {
                // For other remainders, count of remainder must match complement
                if (remainderMap.get(remainder) != remainderMap.getOrDefault(complement, 0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
