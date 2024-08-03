package binarysearch;
import java.util.*;
public class leetcode658 {
    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,3,4,5},4, 3));
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans= new ArrayList<>();
        int count=0;
        int point= search(arr, x);
        if(k==arr.length){
            for(int i=0;i<k;i++){
                ans.add(arr[i]);
            }
        }
        else if(arr[point]==arr[0]){
            for(int i=0;i<k;i++){
                ans.add(arr[i]);
            }
        }
        else if(arr[point]==arr[arr.length-1]){
            for(int i=arr.length-k;i<arr.length;i++){
                ans.add(arr[i]);
            }
        }
        else{
            int left=point;
            int right=point+1;
            //1,2,3,4,5
            while (count<k) {
                if(right==arr.length){
                    if(left>0){
                        ans.add(arr[left]);
                        left--;
                    }
                }
                else if((Math.abs((arr[left]-x)))<=(Math.abs((arr[right]-x))) && left<right){
                    if(left>0){
                        ans.add(arr[left]);
                        left--;
                    }else{
                        ans.add(arr[right]);
                        right++;
                    }
                }
                // else if((Math.abs((arr[left]-x)))>(Math.abs((arr[right]-x))) && left<right){
                //     ans.add(arr[right]);
                //     if(right<arr.length){
                //         right++;
                //     }
                // }
                // else{
                //     if (arr[left]>arr[right]) {
                //         ans.add(arr[right]);
                //         if(right<arr.length){
                //             right++;
                //         }
                //     }
                //     if (arr[left]<arr[right]) {
                //         ans.add(arr[left]);
                //         if(left>0){
                //             left--;
                //         }
                //     }
                // }
                count++;
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public static int search(int[] arr,int x){
        int start=0;
        int end=arr.length-1;
        int nearby=0;
        while (start<end) {
            int mid=start+(end-start)/2;
            if(arr[mid]==x){
                return mid;
            }
            else if (arr[mid]<x){
                start=mid+1;
            }
            else{
                end=mid;
            }
            nearby=mid;
        }
        return nearby;
    }
}
