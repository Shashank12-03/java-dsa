// package binarysearch;
import java.util.*;
public class leetcode153 {
    public static void main(String[] args) 
    {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        int ans=findMin(arr);
        System.out.println(ans);
        t.close();
    }
    static int findMin(int[] arr)
    {
        int Pivot=pivot(arr);
        if(Pivot==-1)
        {
            return arr[0];
        }
        else
        {
        return arr[Pivot+1];
        }
    }
    static int pivot(int[] nums)
    {
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
            if(nums[mid]<=nums[l])
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
}
    /*static int bs(int[] arr,int target,int l, int e)
    {
    
        while(l<=e)
        {
            int mid=l+(e-l)/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            
            if(target<arr[mid])
            {
                e=mid-1;
            }
            else if(target>arr[mid])
            {
                l=mid+1;
            }      
        }
        return -1;
    }  */
 

