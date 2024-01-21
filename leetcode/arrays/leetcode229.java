package arrays;
import java.util.*;
public class leetcode229 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
    }
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans= new ArrayList<>();
        Map<Integer,Integer>map= new HashMap<>();
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int time=nums.length/3;
        for(Map.Entry<Integer, Integer> entry: map.entrySet() ){
            if (time<entry.getValue()) {
                ans.add(entry.getKey());
            }
        }
        if(ans.isEmpty()){
            for(int i=0;i<nums.length;i++){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}
