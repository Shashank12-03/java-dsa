import java.util.Arrays;
import java.util.Scanner;

public class codeforces995II {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        // int t = scanner.nextInt();

        // for (int i = 0; i < t; i++) {
        //     // Read n, x, and y for the current test case
        //     int n = scanner.nextInt();
        //     int x = scanner.nextInt();
        //     int y = scanner.nextInt();

        //     // Read the array a
        //     int[] a = new int[n];
        //     for (int j = 0; j < n; j++) {
        //         a[j] = scanner.nextInt();
        //     }
        //     System.out.println(helper(a,x,y));
        // }
        System.out.println(helper(new int[]{4,6,3,6}, 8, 10));
        scanner.close();
    }
    private static int helper(int[] nums,int x, int y){
        int sum = 0;
        for (int num : nums) {
            sum+=num;
        }
        int lowLimit= sum-y;
        int highLimit = sum-x;
        Arrays.sort(nums);
        
        return getCnt(highLimit,nums)-getCnt(lowLimit-1,nums);
    }
    private static int getCnt(int sum, int[] nums){
        int ans = 0;
        int l = 0;
        int r = nums.length-1;
        while (l<=r) {
            int pair = nums[l]+nums[r];
            if( pair<=sum){
                ans += r-l;
                l++;
            }
            else{
                r--;
            }
        }
        return ans;
    }
}
