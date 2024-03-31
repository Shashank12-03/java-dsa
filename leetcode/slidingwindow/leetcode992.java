package slidingwindow;
import java.util.*;
public class leetcode992 {
    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3));
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return countSubArrays(nums,k)-countSubArrays(nums,k-1);
    }
    private static int countSubArrays(int[] nums, int k) {
        int count=0;
        int left=0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while (map.size()>k) {
                map.put(nums[left],map.get(nums[left])-1);
                if (map.containsKey(nums[left]) && map.get(nums[left])==0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            count+=i-left+1;
        }
        return count;
    }
}
