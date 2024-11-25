package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class leetcode2461 {
    
    public static void main(String[] args) {
        leetcode2461 sol = new leetcode2461();
        System.out.println(sol.maximumSubarraySum(new int[]{1,1,1,7,8,9}, 3));
    }


    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < k;i++){
            if(!map.containsKey(nums[i])){
                sum += nums[i];
            }
            else{
                sum = 0;
            }
            map.put(nums[i],i);
        }
        if (map.size()==k) {
            ans = Math.max(sum,ans);
        }
        
        for(int i = k;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                sum += nums[i];
            }
            else{
                if(map.get(nums[i])!=i-k){
                    sum=0;
                }
            }
            if(sum!=0){
                sum -= nums[i-k];
            }
            map.put(nums[i],i);
            ans = Math.max(sum,ans);
        }
        
        return ans;
    }

}
