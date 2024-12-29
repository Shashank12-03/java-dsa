package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode945 {
    public static void main(String[] args) {
        leetcode945 solution = new leetcode945();
        int[] nums = {3, 2, 1, 2, 1, 7};
        //  1 1 2 2 3 7
        // 0 2 2 1 0 0 0 1
        int result = solution.minIncrementForUnique(nums);
        System.out.println(result);
    }
    public int minIncrementForUnique(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int ans = 0;
        
        return ans;
    }
}
