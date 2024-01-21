package binarysearch;
import java.util.Arrays;

public class leetcode238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{0,0})));
    }
    static int[] productExceptSelf(int[] nums) {
        int mul1=1;
        int mul2=1;
        int zero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }
        }
        for(int i=0;i<nums.length;i++){
            mul1=mul1*nums[i];
            if(nums[i]!=0){
                mul2=mul2*nums[i];
            }
        }
        if(zero>1){
            for(int i=0;i<nums.length;i++){
                nums[i]=0;
            }
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    nums[i]=mul2;
                }
                else if(nums[i]!=0){
                    nums[i]=mul1/nums[i];
                }
            }
        }
        return nums;
    }
}
