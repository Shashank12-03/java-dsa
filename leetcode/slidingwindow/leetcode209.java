package slidingwindow;

public class leetcode209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int start=0;
        int end=0;
        int sum=0;
        int min_length=Integer.MAX_VALUE;
        while(end<nums.length){
            sum+=nums[end];
            end++;
            while(start<end && sum>=target){
                sum=sum-nums[start];
                start++;
                min_length=Math.min(end-start+1, min_length);
            }
        }
        if(min_length==Integer.MAX_VALUE){
            return 0;
        }
        return min_length;
    }
    
}
