package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode532
 */
public class leetcode532 {

    public static void main(String[] args) {
        leetcode532 sol = new leetcode532();
        System.out.println(sol.findPairs(new int[]{3,1,4,1,5}, 2));
    }
    
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            int target = nums[i]+k;
            if(!set.contains(nums[i])){
                if(target!=nums[i] && map.containsKey(target) ){
                    cnt++;
                }
                else if(target==nums[i] && map.containsKey(target)){
                    if(map.get(target)>=2){
                        cnt++;
                    }
                }
                set.add(nums[i]);
            }
        }
        return cnt;
    }
}