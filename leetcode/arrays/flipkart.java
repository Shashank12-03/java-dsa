package arrays;

import java.util.ArrayList;
public class flipkart {
    public static void main(String[] args) {
        int[]arr={8,5,10,7,9,4,15,12,90,13};
        // 10 10 10 15 15 90 90
        // 10 10 15 15 90 90
        System.out.println(max_of_subarrays(arr, arr.length, 5));
    }
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList <Integer> list=new ArrayList <Integer>();
        int max =0;
        for(int i =0;i<k;i++){
            max = Math.max(max, arr[i]);
        }
        list.add(max);
        // int MaxTill = max;
        for(int i=k;i<n;i++){
            max = Math.max(max, arr[i]);
            if(max!=arr[i-k]){
                list.add(max);
            }
            // int max=0;
            // for(int j=i;j<k+i;j++){
            //     max=Math.max(arr[j],max);
            // } 
            // list.add(max);
        }
        return list;
    }
}