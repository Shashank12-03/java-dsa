package binarysearch;
import java.util.*;
public class leetcode162 {
    public static void main(String[] args) 
    {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        int target=t.nextInt();
        int ans=search(arr, target);
        System.out.println(ans);
        t.close();
    }
    static int search(int[] arr,int target)
    {
        int Peak=peak(arr);
        int firsttry=bs(arr, target, 0, Peak);
        if (firsttry!=-1)
        {
            return firsttry;
        }
        return bs(arr, target, Peak+1, arr.length-1);
    }
    static int peak(int[] nums)
    {
        int l=0;
        int e=nums.length-1;
        while(l<e)
        {
            int mid=l+(e-l)/2; 
            if(nums[mid+1]<nums[mid])
            {
                e=mid;
            }
            else 
            {
                l=mid+1;
            }
        }
        return l;
    }
    static int bs(int[] arr,int target,int l, int e)
    {
        boolean isAsc=arr[l]<arr[e];
        while(l<=e)
        {
            int mid=l+(e-l)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            if(isAsc)
            {
                if(target<arr[mid])
                {
                    e=mid-1;
                }
                else if(target>arr[mid])
                {
                    l=mid+1;
                }
            }
            else
            {
                if(target>arr[mid])
                {
                    e=mid-1;
                }
                else if(target<arr[mid])
                {
                    l=mid+1;
                } 
            }
            return mid;      
        }
        return -1;
    }  
}


