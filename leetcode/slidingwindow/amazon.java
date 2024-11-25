package slidingwindow;

import java.util.*;

public class amazon {

    public static int minSubarrayPriceWithDuplicates(int[] prices) {
        int n = prices.length;
        int minSum = Integer.MAX_VALUE;

        // Map to store the last seen index of each price
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int price = prices[i];

            // If duplicate is found, calculate sum for subarray containing it
            if (lastSeen.containsKey(price)) {
                int start = lastSeen.get(price);
                int subarraySum = 0;

                // Calculate sum of the subarray from start to i (inclusive)
                for (int j = start; j <= i; j++) {
                    subarraySum += prices[j];
                }

                // Update minimum sum if this subarray sum is smaller
                minSum = Math.min(minSum, subarraySum);
            }

            // Update last seen index for current price
            lastSeen.put(price, i);
        }

        // If no subarray with duplicates found, return 0, else return minSum
        return minSum == Integer.MAX_VALUE ? 0 : minSum;
    }

    public static void main(String[] args) {
        int[] prices = {0,1,0,0,2,0,3,0,4,5,0,1,0,16,0,5};
        int result = minSubarrayPriceWithDuplicates(prices);
        System.out.println(result);  // Output: 4
    }
}