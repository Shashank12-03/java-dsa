package dp;


public class leetcode801 {
    public static void main(String[] args) {
        leetcode801 sol = new leetcode801();
        System.out.println(sol.minSwap(new int[]{0,7,8,10,10,11,12,13,19,18}, new int[]{4,4,5,7,11,14,15,16,17,20}));
    }
    public int minSwap(int[] nums1, int[] nums2) {
        int[] arr1 = nums1.clone();
        int[] arr2 = nums2.clone();
        int swap1 = 0;
        for(int i =1;i< nums1.length;i++){
            if((nums1[i]<=nums1[i-1])||(nums2[i]<=nums2[i-1])){
                int temp = nums1[i];
                nums1[i] = nums2[i];
                nums2[i] = temp; 
                swap1++;
            }
        }
        int swap2 = 0;
        for(int i =0;i< arr1.length-1;i++){
            if((arr1[i]>=arr1[i+1])||(arr2[i]>=arr2[i+1])){
                int temp = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = temp; 
                swap2++;
            }
        }
        
        
    }
}
