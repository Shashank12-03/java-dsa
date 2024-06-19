package binarysearch;

public class leetcode4 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ans=mergesort(nums1, nums2);
        int mid=ans.length/2;
        if(ans.length%2!=0){
            return (double)ans[mid];
        }
        
        return  (double)(ans[mid]+ans[mid-1])/2;
        
    }
    static int[] mergesort(int[] first,int[] second){
        int i=0;
        int j=0;
        int k=0;
        int[]temp=new int[first.length+second.length];
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                temp[k++]=first[i];
                i++;
            }
            else{
                temp[k++]=second[j];
                j++;
            }
        }
        while(i<first.length){
            temp[k++]=first[i];
            i++;
        }
        while(j<second.length){
            temp[k++]=second[j];
            j++;
        }
        return temp;
    }
}
