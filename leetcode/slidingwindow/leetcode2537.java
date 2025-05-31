package slidingwindow;

import java.util.HashMap;
import java.util.Map;


public class leetcode2537 {
    public static void main(String[] args) {
        leetcode2537 sol = new leetcode2537();
        System.out.println(sol.countGood(new int[]{3,1,4,3,2,2,4}, 2));
    }
    public long countGood(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int end = 0;
        int start = 0;
        long result = 0;
        int pairs = 0;
        int n = nums.length;
        while (end<nums.length){
            if (map.containsKey(nums[end])) {
                pairs+=map.get(nums[end]);
            }
            
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            while (pairs >= k) {
                result += (n - end); 
                pairs -= (map.get(nums[start]) - 1); 
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }
                start++;
            }
            end++;
        }
        return result;
    }
}
