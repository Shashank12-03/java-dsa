package slidingwindow;


public class leetcode1004 {
    public static void main(String[] args) {
        // System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
    public static int longestOnes(int[] nums, int k) {
        int st = 0;
        int en = 0;
        int maxNoOfOnes = 0;
        int noOfZeros = 0;

        while (en < nums.length) {
            if (nums[en] == 0) {
                noOfZeros++;
            }

            while (noOfZeros > k) {
                if (nums[st] == 0) {
                    noOfZeros--;
                }
                st++;
            }

            maxNoOfOnes = Math.max(maxNoOfOnes, en - st + 1);
            en++;
        }
        
        return maxNoOfOnes;
    }
}
