package slidingwindow;

public class leetcode2444 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,3,5,2,7,5}, 1, 5));
    }
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int min=0;
        int max=0;
        int left=0;
        long cnt=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==minK) {
                min=i;
            }
            if (nums[i]==maxK) {
                max=i;
            }
            if (i>=min && i<=max) {
                left=i+1;
            }
            cnt+=Math.max(0, Math.min(min, max)-left+1);
        }
        return cnt;
    }
}
