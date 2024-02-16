package arrays;
import java.util.*;
public class leetcode169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> store=new HashMap<>();
        for (int i : nums) {
            store.put(i, store.getOrDefault(i, 0)+1);
        }
        int maxValue = Integer.MIN_VALUE;
        int maxKey=Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
        // int max=Integer.MIN_VALUE;
        // int min=Integer.MAX_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     min=Math.min(min,nums[i]);
        // }
        // for(int i=0;i<nums.length;i++){
        //     nums[i]+=Math.abs(min);
        //     max=Math.max(max,nums[i]);
        // }
        // int[] store=new int[max+1];
        // for(int i=0;i<nums.length;i++){
        //     store[nums[i]]++;
        // }
        // max=0;
        // int ans=0;
        // for(int i=0;i<store.length;i++){
        //     if(max<=store[i]){
        //         max=store[i];
        //         ans=i;
        //     }
        // }
        // return ans-Math.abs(min);
    }
}
