package sorting;
import java.util.*;
public class leetcode88{
    public static void main(String[] args) {
        int m=3;
        int n=3;
        int[] arr1={1,2,3,0,0,0};
        int[] arr2={2,5,6};
        merge(arr1, m, arr2, n);
    }
    static void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = 0, j = 0, k = arr1.length-n-1;
        while (i <= k && j < n) {
            if (arr1[i] < arr2[j])
                i++;
            else {
                int temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;
                j++;
                k--;
            }
        }
        j=0;
        for(i=m;i<arr1.length;i++){
            arr1[i]=arr2[j];
            j++;
        }
        System.out.println(Arrays.toString(arr2));
    }
}