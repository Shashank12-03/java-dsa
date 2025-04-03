package arrays;

public class leetcode2874 {

    public static void main(String[] args) {
        int[] nums = {1000000,1,1000000};
        leetcode2874 obj = new leetcode2874();
        long result = obj.maximumTripletValue(nums);
        System.out.println("Maximum Triplet Value: " + result);
    }
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        } 
        int[] suffixMax = new int[n]; 
        suffixMax[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
        } 

        for(int i = 1;i<n-1;i++){
            long value = (long) (prefixMax[i-1]-nums[i])*suffixMax[i+1];
            ans = Math.max(ans,value);
        }
        return ans;
    }
}
