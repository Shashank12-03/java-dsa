package slidingwindow;


public class leetcode2302 {

    public static void main(String[] args) {
        leetcode2302 solution = new leetcode2302();
        int[] nums = {2,1,4,3,5};
        long k = 10;
        long result = solution.countSubarrays(nums, k);
        System.out.println("Number of subarrays: " + result);
    }
    public long countSubarrays(int[] nums, long k) {
        // long [] prefix = new long[nums.length];
        // long prefixSum = 0;
        // for(int i = 0;i<nums.length;i++){
        //     prefixSum+=nums[i];
        //     prefix[i] = prefixSum;
        // }
        long ans = 0;
        int st = 0;
        long sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            while(sum*(i-st+1)>=k){
                sum -= nums[st];
                st++;
            }
            ans += (i-st+1);
        }
        return ans;
    }
}