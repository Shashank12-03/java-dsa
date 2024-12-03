package slidingwindow;

import java.util.HashMap;
import java.util.Map;


public class leetcode2537 {
    public static void main(String[] args) {
        leetcode2537 sol = new leetcode2537();
        System.out.println(sol.countGood(new int[]{1,1,1,1,1}, 10));
    }
    public long countGood(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int end = 0;
        int start = 0;
        long count = 0;
        int pairs = 0;
        
        while (end<nums.length) {
            if (map.containsKey(nums[end])) {
                pairs++;
            }
            if (pairs==k) {
                count++;
            }
            while (pairs>k) {
                if (map.get(nums[start])==2) {
                    map.put(nums[start],map.get(nums[start])-1);
                    pairs--;
                }
                start++;
            }
            map.put(nums[end], map.getOrDefault(nums[end],0)+1);
            end++;
        }
        return count;
    }
}
