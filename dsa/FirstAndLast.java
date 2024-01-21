import java.util.*;
public class FirstAndLast {
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
        int[] ans=new int[2];
        ans=searchRange(arr,target);
        for(int i=0;i<2;i++) 
        {
            System.out.println(ans[i]);
        }   
        t.close();    
    }
    static int[] searchRange(int[] nums, int target) 
    {
       int[] a={-1,-1};
       int start=search(nums, target, true);
       int last=search(nums, target, false);
       a[0]=start;
       a[1]=last;
       return a;
    }
    static int search(int[] nums,int target,boolean startindex)
    {
        int l=0;
        int e=nums.length-1;
        int ans=-1;
        while(l<=e)
        {
            int mid=l+(e-l)/2; 
            if(nums[mid]==target)
            {
                 
            }
            if(target<nums[mid])
            {
                e=mid-1;
            }
            else if(target>nums[mid])
            {
                l=mid+1;
            }
            else 
            {
                ans=mid;
                if(startindex==true)
                {
                    e=mid-1;
                }
                else
                {
                    l=mid+1;
                }
            }
        }
        return ans;
    }
    
}
