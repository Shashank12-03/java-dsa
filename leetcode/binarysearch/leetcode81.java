package binarysearch;

public class leetcode81 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3,5,1}, 3));
    }
    public static boolean search(int[] nums, int target) {
        int Pivot=pivot(nums);
        if(Pivot==-1){
            return linsearch(nums,0,nums.length,target);
        }
        if(target==nums[Pivot]){
            return true;
        }
        else if(target>=nums[0]){
            return linsearch(nums,0, Pivot,target);
        }
        else{
            return linsearch(nums,Pivot,nums.length,target);
        }
    }
    public static int pivot(int[] nums){
        int l=0;
        int e=nums.length-1;
        while(l<=e)
        {
            int mid=l+(e-l)/2; 
            if(mid<e && nums[mid+1]<nums[mid])
            {
                return mid;
            }
            if(mid>l && nums[mid]<nums[mid-1])
            {
                return mid-1;
            }
            if(nums[mid]<nums[l])
            {
                e=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return -1;
    }
    public static boolean linsearch(int[] nums, int start,int end,int target){
        for(int i=start;i<end;i++){
            if(nums[i]==target){
                return true;
            }
        }
        return false;
    }
}
