package binarysearch;

public class occurance {
    public static void main(String[] args) {
        
    }
    public static int count(int[] arr, int n, int x) {
        // code here
        int st = 0;
        int en = n-1;
        int first = -1;
        while(st<=en){
            int mid = st+(en-st)/2;
            if(arr[mid]==x){
                first = mid;
                en = mid-1;
            }
            if (arr[mid]>x){
                en = mid-1;
            }
            if(arr[mid]<x){
                st = mid+1;
            }
        }
        if (first == -1){
            return 0;
        }
        st = 0;
        en = n-1;
        int last = -1;
        while(st<=en){
            int mid = st+(en-st)/2;
            if(arr[mid]==x){
                last = mid;
                st = mid+1;
            }
            if (arr[mid]>x){
                en = mid-1;
            }
            if(arr[mid]<x){
                st = mid+1;
            }
        }
        return last-first +1;
    }
}
