package binarysearch;
import java.util.*;
public class leetcode852 {
    public static void main(String[] args) 
    {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        int ans=search(arr);
        System.out.println(ans);
        t.close();
    }
    static int search(int[] nums)
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
}
