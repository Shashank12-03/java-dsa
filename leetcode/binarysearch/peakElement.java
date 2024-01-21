// package binarysearch;
import java.util.*;
public class peakElement {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        int ans=findPeakElement(arr);
        System.out.println(ans);
        t.close();
    }
    public static int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        if(nums.length==1)
        {
            return 0;
        }
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if (mid==0)
            {
                if(nums[mid]>nums[mid+1])
                {
                    return mid;
                }
                else
                {
                    start=mid+1;
                }
            }
            else if(mid==nums.length-1)
            {
                if(nums[mid]>nums[mid-1])
                {
                    return mid;
                }
                else{
                    end=mid-1;
                }
            }
            else
            {
                if(nums[mid]>=nums[mid-1] && nums[mid]>=nums[mid+1])
                {
                    return mid;
                }
                else if(nums[mid+1]>nums[mid])
                {
                    start=mid+1;
                }
                else 
                {
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
