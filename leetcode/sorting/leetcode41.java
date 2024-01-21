package sorting;
import java.util.*;
public class leetcode41 {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        int ans=firstMissingPositive(arr);
        System.out.println(ans);
        t.close();
    }
    static int firstMissingPositive(int[] arr) {
        int i=0;
        while(i<arr.length)
        {
            int correct=arr[i]-1;
            if(arr[correct]!=arr[i] && arr[i]>0 && arr[i]<=arr.length)
            {
                swap(arr,i,correct);
            }
            else
            {
                i++;
            }
        }
        for(int j=0;j<arr.length;j++)
        {
            if(arr[j]!=j+1)
            {
                return j+1;
            }
        }
        return arr.length+1;
    }
    static void swap(int[] arr,int i,int correct)
    {
        int temp=arr[i];
        arr[i]=arr[correct];
        arr[correct]=temp;
    }
}
