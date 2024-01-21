//  package binarysearch;
import java.util.Scanner;

public class gfgBS {
    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        int n=t.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=t.nextInt();
        }
        int k=t.nextInt();
        System.out.println(findPages(arr,n,k));
        t.close();
    }
    static int findPages(int[]A,int N,int M)
    {
        int max=0;
        int sum=0;
        for(int i=0;i<N;i++){
            max=Math.max(A[i], max);
            sum+=A[i];
        }
        int s=max;
        int e=sum;
        // no. of student is greater than no. of books return -1
        if(M>N){
            return -1;
        }
        //if no. of books is equal to student then min pages read is equal to max of array
        if(M==N){
            return max;
        }
        int ans=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(ToFindMin(A,mid,M)){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
    static boolean ToFindMin(int[] arr,int mid,int days){
        int pages=0;
        int student=1;
        for(int i=0;i<arr.length;i++){
            if(pages+arr[i]>mid){
                student++;
                pages=arr[i];
            }
            else{
                pages+=arr[i];
            }
        }
        return student<=days;
    }
}
