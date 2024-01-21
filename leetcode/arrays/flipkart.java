package arrays;

import java.util.ArrayList;
public class flipkart {
    public static void main(String[] args) {
        int[]arr={8,5,10,7,9,4,15,12,90,13};
        System.out.println(max_of_subarrays(arr, arr.length, 4));
    }
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList <Integer> list=new ArrayList <Integer>(n-k+1);
        for(int i=0;i<n-k+1;i++){
            int max=0;
            for(int j=i;j<k+i;j++){
                max=Math.max(arr[j],max);
            } 
            list.add(max);
        }
        return list;
    }
}