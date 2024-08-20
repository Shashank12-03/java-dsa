package dp;
public class leetcode2035 {
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{3,9,7,3}));
    }
    public static int minimumDifference(int[] arr) {
        // int n = nums.length;
        // int min_ele=Integer.MAX_VALUE;
        // int[] prefix = new int[n + 1];
        // Arrays.sort(nums);
        // for (int i = 0; i < n; i++) {
        //     min_ele=Math.min(min_ele, nums[i]);
        // }
        // for (int i = 0; i < n; i++) {
        //     nums[i]+=Math.abs(min_ele);
        // }
        // for(int i = 0; i < n; i ++) {
        //     prefix[i + 1] = nums[i] + prefix[i];
        // }
        // int total = prefix[prefix.length - 1];
        // int half = n / 2;
        // int i = 0;
        // int res = Integer.MAX_VALUE;
        // for( ; half < n + 1; half++, i++){
        //     int curr = prefix[half] - prefix[i];
        //     res = Math.min(res, Math.abs(total - curr - curr));
        // }
        // return res;
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        boolean[][] dp = new boolean[arr.length][totalSum + 1];

        // Initialize first row
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= totalSum) {
            dp[0][arr[0]] = true;
        }

        // Fill the DP table
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= totalSum; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (arr[i] <= j) {
                    take = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = take || notTake;
            }
        }

        // Find the minimum difference
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= totalSum / 2; i++) {
            if (dp[arr.length - 1][i]) {
                min = Math.min(min, Math.abs((totalSum - i) - i));
            }
        }

        return min;
    }
}
