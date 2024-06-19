package binarysearch;
// import java.util.*;
public class leetcode1011 {
    public static void main(String[] args) {
        // Test the function with a given array of weights and number of days
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }

    static int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;

        // Calculate the maximum single weight and the total weight
        for(int i = 0; i < weights.length; i++) {
            max = Math.max(weights[i], max);
            sum += weights[i];
        }

        // Set the initial range for binary search
        int s = max; // Minimum capacity of the ship should be at least the heaviest package
        int e = sum; // Maximum capacity could be the sum of all packages if shipped in one day

        // Special case: if the number of days equals the number of packages, each package is shipped alone
        if(days == weights.length) {
            return max;
        }

        int ans = -1;

        // Perform binary search to find the minimum ship capacity to ship within the given days
        while(s <= e) {
            int mid = s + (e - s) / 2; // Calculate mid-point capacity
            if(canshipcargo(weights, mid, days)) { // Check if it's possible to ship with this capacity
                ans = mid; // If possible, record this as a potential answer
                e = mid - 1; // Try for a smaller capacity
            } else {
                s = mid + 1; // Increase the capacity
            }
        }
        return ans; // Return the minimum capacity found
    }

    // Helper function to check if we can ship all packages within the given days with a specific capacity
    static boolean canshipcargo(int[] arr, int mid, int days) {
        int weight = 0;
        int day = 1; // Start with the first day

        // Iterate through each package
        for(int i = 0; i < arr.length; i++) {
            if(weight + arr[i] > mid) { // If adding the current package exceeds capacity
                day++; // Increment the day
                weight = arr[i]; // Start a new day with the current package
            } else {
                weight += arr[i]; // Add the package to the current day's load
            }
        }
        return day <= days; // Return true if we can ship within the given days, false otherwise
    }
}
