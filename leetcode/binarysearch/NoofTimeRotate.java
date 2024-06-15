package binarysearch;

public class NoofTimeRotate {
    public static void main(String[] args) {
        System.out.println(findKRotation(new int[]{5,1,2,3,4}, 5));
    }
    public static int findKRotation(int arr[], int n) {
        int start=0, end=n-1;
        while(start<end){
            int mid = start +(end-start)/2;
            if(arr[mid]>arr[end]) start = mid+1;
            else end = mid;
        }
        return end;
    }
}
