package sorting;
import java.util.Arrays;

public class leetcode349 {
    public static void main(String[] args) {
        int[] arr1={1,2,2,1};
        int[] arr2={2,2};
        System.out.println(Arrays.toString(intersection(arr1,arr2)));
    }
    static int[] intersection(int[] nums1, int[] nums2) {
        int max=Math.max(nums1.length, nums2.length);
        int[] temp= new int[max];
        int k=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if((nums1[i]==nums2[j])){
                    temp[k++]=nums1[i];
                }
            }
        }
        return temp;
    }
}
