package arrays;

import java.util.Arrays;

public class leetcode2149 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{3,1,-2,-5,2,-4})));
    }
    public static int[] rearrangeArray(int[] nums) {
        // int[] odd=new int[nums.length/2];
        // int[] even=new int[nums.length/2];
        // int od=0;
        // int ev=0;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]>=0){
        //         even[ev++]=nums[i];
        //     }
        //     else{
        //         odd[od++]=nums[i];
        //     }
        // }
        // od=0;
        // ev=0;
        // for(int i=0;i<nums.length;i++){
        //     if(i%2==0){
        //         nums[i]=even[ev++];
        //     }
        //     else{
        //         nums[i]=odd[od++];
        //     }
        // }
        // return nums;
        int[] ans=new int[nums.length];
        int pos=0;
        int neg=1;
        for(int num:nums){
            if(num>=0){
                ans[pos]=num;
                pos+=2;
            }
            else{
                ans[neg]=num;
                neg+=2;
            }
        }
        return ans;
    }
}
