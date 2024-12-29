package binarysearch;

public class leetcode1855 {
    public static void main(String[] args) {
        
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i]<=nums2[j]) {
                ans = Math.max(ans, j-i);
                j++;
            }
            else{
                i++;
            }
        }
        return ans;
    }
    // public int maxDistance(int[] nums1, int[] nums2) {
    //     int ans = 0;
    //     for(int i = 0;i<nums1.length;i++){
    //         int l = i;
    //         int r = nums2.length-1;
    //         while(l<=r){
    //             int mid = l + (r-l)/2;
    //             if(nums1[i]<=nums2[mid]){
    //                 ans = Math.max(ans,mid-i);
    //                 l = mid+1;
    //             }
    //             else{
    //                 r = mid-1;
    //             }
    //         }
    //     }
    //     return ans;
    // }
}
