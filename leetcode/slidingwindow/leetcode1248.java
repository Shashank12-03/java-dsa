package slidingwindow;

public class leetcode1248 {
    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{0,0,0,1,0,0,1,0,0,0}, 2));
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int ans = 0, t = 0;
        for (int v : nums) {
            t += v & 1;
            if (t - k >= 0) {
                ans += cnt[t - k];
            }
            cnt[t]++;
        }
        return ans;
    }
}
