package arrays;

import java.util.HashMap;
import java.util.Map;

public class leetcode3371 {

    public static void main(String[] args) {
        leetcode3371 sol = new leetcode3371();
        System.out.println(sol.getLargestOutlier(new int[]{2,3,5,10}));
    }

    public int getLargestOutlier(int[] nums) {
        int n = nums.length;
        if(n==3){
            if(nums[0]==nums[1]){
                return nums[2];
            }
            else if(nums[1]==nums[2]){
                return nums[0];
            }
            return nums[1];
        }
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            sum+=nums[i];
        }
        for(int num:nums){
            int number =sum-num;
            map.put(num, map.get(num)-1);
            if (map.get(num)==0) {
                map.remove(num);
            }
            if(number%2==0 && map.containsKey(number/2)){
                ans = Math.max(ans,num);
            }
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return ans;
    }
}
