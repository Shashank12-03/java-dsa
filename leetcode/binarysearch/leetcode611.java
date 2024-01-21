package binarysearch;
import java.util.Arrays;
public class leetcode611 {
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2,2,3,4}));
    }
    static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        // int start=0;
        // int end=nums.length-1;
        // while(start<=end){
        //     int mid=start+(end-start)/2;
        //     if(((nums[start]+nums[end])>nums[mid]) && ((nums[mid]+nums[end])>nums[start]) && ((nums[start]+nums[mid])>nums[end])){
        //         count++;
        //     }
        //     if((nums[mid]+nums[end])>nums[start]){
        //         start++;
        //     }
        //     if((nums[start]+nums[mid])>nums[end]){
        //         end--;
        //     }
        // }
        for(int i=2;i<nums.length;i++){
            count+=helper(i,nums);
        }
        return count;
    }
    static int helper(int i,int[] nums){
        int start=0;
        int end=i-1;
        int ans=0;
        while(start<end){
            if((nums[start]+nums[end])>nums[i]){
                ans=end-start;
                //not just the current triangle but also the sides that is greater than left (before right)
                //will also make traingles
                end--;
            }
            else{
                start++;
            }
        }
        return ans;
    }
}
