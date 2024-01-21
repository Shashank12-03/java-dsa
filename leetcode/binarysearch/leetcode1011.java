package binarysearch;
import java.util.*;
public class leetcode1011 {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        int k=t.nextInt();
        System.out.println(shipWithinDays(arr,k));
        t.close();
    }
    static int shipWithinDays(int[] weights, int days) {
        int max=0;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            max=Math.max(weights[i], max);
            sum+=weights[i];
        }
        int s=max;
        int e=sum;
        //if no. of elements is equal to days then max cargo shipped in one day is equal to max of array
        if(days==weights.length){
            return max;
        }
        int ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(canshipcargo(weights,mid, days)){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
    static boolean canshipcargo(int[] arr,int mid,int days){
        int weight=0;
        int day=1;
        for(int i=0;i<arr.length;i++){
            if(weight+arr[i]>mid){
                day++;
                weight=arr[i];
            }
            else{
                weight+=arr[i];
            }
        }
        return day<=days;
    }
}
