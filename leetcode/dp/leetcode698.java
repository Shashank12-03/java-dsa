package dp;

import java.util.*;

public class leetcode698 {
    public static void main(String[] args) {
        leetcode698 sol = new leetcode698();
        System.out.println(sol.canPartitionKSubsets(new int[]{2,9,2,2,4,1,12,1,1}, 2));
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for(int num:nums){
            totalSum+=num;
        }
        if(totalSum%k!=0){
            return false;
        }
        Arrays.sort(nums);
        int partSum = totalSum/k;
        int cnt = 0;
        for(int i = 0;i<nums.length;i++){
            int sum = nums[i];
            for(int j = 0;j<nums.length;j++){
                if(sum==partSum){
                    cnt++;
                    sum = nums[i];
                }
                else if(sum>partSum){
                    sum = nums[i];
                    continue;
                }
                if(i!=j){
                    sum+=nums[j];
                }
                if(cnt==k){
                    return true;
                }
            }
        }
        if(k==cnt){
            return true;
        }
        return false;
    }
}
