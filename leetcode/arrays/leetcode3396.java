package arrays;

import java.util.HashMap;
import java.util.Map;

public class leetcode3396 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,3,3,5,7};
        leetcode3396 obj = new leetcode3396();
        int result = obj.minimumOperations(nums);
        System.out.println("Minimum operations: " + result);
    }
    public int minimumOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = nums.length-1;i>=0;i--){
            if(map.containsKey(nums[i])){
                double ans = (double) i/3;
                if (i % 3 == 0) {
                    ans = (double) i / 3 + 1;
                }
                return (int) Math.ceil(ans);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return 0;
    }
}
