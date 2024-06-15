// import java.util.*;
public class Ceil {
    public static void main(String[] args) 
    {
        // Scanner t=new Scanner(System.in);
        // int n=t.nextInt();
        // int[] arr=new int[n];
        // for(int i=0;i<n;i++)
        // {
        //     arr[i]=t.nextInt();
        // }
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(arr[i]);
        // }
        // System.out.println();
        // int target=t.nextInt();
        // int ans=ceil(arr,target);
        // System.out.println(ans);
        // t.close();
        System.out.println(ceil(new int[]{2,3,4,6,9,12,14},8));
    }
    public static int ceil(int[] arr,int target)
    {
        if (target>arr[arr.length-1])
        {
            return -1;
        }
        int l=0;
        int e=arr.length-1;
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
        return arr[l];
    }
}
