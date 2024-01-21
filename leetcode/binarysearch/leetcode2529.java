// package binarysearch;
public class leetcode2529 {
    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{-3,-2,-1,0,0,1,2}));
    }
    static int maximumCount(int[] nums) {
        // int start=0;
        // int end=nums.length-1;
        // int pivot=nums.length;
        // while(start<=end){
        //     int mid=start+(end-start)/2;
        //     if((nums[mid]>=0) && (nums[mid-1]<0)){
        //         pivot=mid;
        //         break;
        //     }
        //     if(nums[mid]>0){
        //         end=mid-1;
        //     }
        //     if(nums[mid]<0){
        //         start=mid+1;
        //     }
        // }
        int pos=0;
        int neg=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                pos++;
            }
            if(nums[i]<0){
                neg++;
            }
        }
        // int neg=pivot;
        // int pos=nums.length-neg;
        return Math.max(neg, pos);
    }
}
