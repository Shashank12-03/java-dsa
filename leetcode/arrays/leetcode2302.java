package arrays;

import java.util.Arrays;

public class leetcode2302 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,1,1}, 5));
    }
    public static long countSubarrays(int[] nums, long k) {
        long count=0;
        int max= Arrays.stream(nums).max().getAsInt();
        if(k>max){
            count=nums.length;
        }
        int sum=nums[0];
        int j=0;
        for(int i=1+j;i<nums.length;i++){
            sum+=nums[i];
            if(sum*i<k){
                count++;
            }
            else{
                sum=0;
                j=i-1;
            }
        }
        return count;
    }
}
