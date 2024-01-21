package arrays;

import java.util.*;
public class leetcode128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
    public static int longestConsecutive(int[] nums) {
        //O(nlogn)
        // Arrays.sort(nums);
        // int longest=1;
        // int count=0;
        // int lastsmaller=Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     if(lastsmaller==nums[i]-1){
        //         count++;
        //         lastsmaller=nums[i];
        //     }
        //     else if(lastsmaller!=nums[i]){
        //         count=1;
        //         lastsmaller=nums[i];
        //     }
        //     longest=Math.max(longest, count);
        // }
        //O(n)
        if(nums.length==0){
            return 0;
        }
        int longest=1;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int number:set){
            if(!set.contains(number-1)){
                int count=1;
                int x=number;
                while (set.contains(x+1)) {
                    x=x+1;
                    count++;
                }
                longest=Math.max(longest, count);
            }
        }
        return longest;
    }
}
