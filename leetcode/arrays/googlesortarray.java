package arrays;

import java.util.Arrays;

public class googlesortarray {
    public static void main(String[] args) {
        int[] nums={3,14,5,16,8,-2,3};
        sortodd(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortodd(int[] nums){
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*2;
            nums[i]+=1;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            nums[i]-=1;
            nums[i]=nums[i]/2;
        }
    }
}
