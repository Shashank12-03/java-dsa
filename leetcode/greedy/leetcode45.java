package greedy;

public class leetcode45 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,0,4}));
    }
    public static int jump(int[] nums) {
        int left=0,right=0;
        int count=0;
        while (right<nums.length-1) {
            int farthest=0;
            for (int i = left; i <= right; i++) {
                farthest=Math.max(farthest, i+nums[i]);
            }
            left=right+1;
            right=farthest;
            count++;
        }
        return count;
    }
}
