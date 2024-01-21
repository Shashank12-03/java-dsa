package arrays;

import java.util.Arrays;

public class leetcode1685 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(new int[]{2,3,5})));
    }
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    sum+=Math.abs(nums[i]-nums[j]);
                }
            }
            ans[i]=sum;
        }
        return ans;
    }
}
