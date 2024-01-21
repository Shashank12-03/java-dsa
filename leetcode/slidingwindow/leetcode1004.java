package slidingwindow;


public class leetcode1004 {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
    public static int longestOnes(int[] nums, int k) {
        int start=0;
        int end=0;
        int max_length=0;
        while (end<nums.length) {
            if(nums[end]==1){
                end++;
            }
            if(nums[end]==0 && k>0){
                end++;
                k--;
            }
            start++;
        }
        return max_length;
    }
}
