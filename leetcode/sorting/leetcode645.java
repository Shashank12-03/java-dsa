package sorting;
import java.util.*;
public class leetcode645 {
   public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        int[] ans=new int[2];
        ans=findErrorNums(arr);
        for(int i=0;i<n;i++)
        {
            System.out.println(ans[i]);
        }
        // System.out.println(ans);
        t.close();
    }

    static int[] findErrorNums(int[] arr)
    {
        int i=0;
        while(i<arr.length)
        {
            int correct=arr[i]-1;
            if(arr[correct]!=arr[i])
            {
                swap(arr,i,correct);
            }
            else
            {
                i++;
            }
        }
        int[] a=new int[2];
        for(int j=0;j<arr.length;j++)
        {
            if(arr[j]!=j+1)
            {
                a[0]=arr[j];
                a[1]=j+1;  
            }
        }
        return a;
    }
    static void swap(int[] arr,int i,int correct)
    {
        int temp=arr[i];
        arr[i]=arr[correct];
        arr[correct]=temp;
    }
}

