package arrays;

// package arrays;

import java.util.ArrayList;
import java.util.List;
public class leetcode368 {
    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1,2,3}));
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    if((nums[i]%nums[j]==0)|| (nums[j]%nums[i]==0)){
                        ans.add(nums[i]);
                    }
                }
            }
        }
        return ans;
    }
}
