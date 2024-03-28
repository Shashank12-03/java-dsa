package slidingwindow;
import java.util.*;

public class leetcode2958 {
    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2}, 2));
    }
    public static int maxSubarrayLength(int[] nums, int k) {
        int start=0;
        HashMap <Integer,Integer> map = new HashMap<>();
        int max_length=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while (map.get(nums[i])>k) {
                map.put(nums[start],map.get(nums[start])-1);
                start++;
            }
            max_length=Math.max(max_length, i-start+1);
        }
        return max_length;
    }
}
