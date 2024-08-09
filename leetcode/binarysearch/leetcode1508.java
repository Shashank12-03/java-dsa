package binarysearch;

import java.util.Arrays;

public class leetcode1508 {
    public static void main(String[] args) {
        System.out.println(rangeSum(new int[]{1,2,3,4}, 4, 1, 5));
    }
    public static int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr = new int[(n*(n+1)/2)];
        int k =0;
        for(int i =0;i<n;i++){
            int sum = 0;
            for(int j =i;j<n;j++){
                sum+=nums[j];
                arr[k++]=sum;
            }
        }
        Arrays.sort(arr);
        int sum=0;
        for(int i =left-1;i<right;i++){
            sum+=arr[i];
        }
        return sum;    
    }
}
