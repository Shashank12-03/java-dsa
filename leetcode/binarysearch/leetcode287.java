package binarysearch;
// import java.util.*;
public class leetcode287 {
    public static void main(String[] args) 
    {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }
    static int findDuplicate(int[] nums) {
        // int slow=nums[0];
        // int fast=nums[0];
        // do
        // {
        //     slow=nums[slow];
        //     fast=nums[nums[fast]];
        // }while(slow!=fast);
        
        // fast=nums[0];
        // while(slow!=fast)
        // {
        //     slow=nums[slow];
        //     fast=nums[fast];
        // }
        // return slow;
        int[] store=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            store[nums[i]]++;
        }
        int index=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < store.length; i++) {
            if(max<store[i]){
                index=i;
                max=store[i];
            }
        }
        return index;
    }
}
