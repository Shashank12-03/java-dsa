package sorting;
import java.util.*;
public class leetcode2164 {
    public static void main(String[] args) {
        int[] arr={4,1,2,3};
        System.out.println(Arrays.toString(sortEvenOdd(arr)));
    }
    static int[] sortEvenOdd(int[] nums) {
        for(int i=1;i<nums.length;i+=2){
            for(int j=i+2;j<nums.length;j+=2){
                if(nums[i]<nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        for(int i=0;i<nums.length;i+=2){
            for(int j=i+2;j<nums.length;j+=2){
                if(nums[i]>nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        return nums;
    }
}
