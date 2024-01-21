// import java.util.Arrays;
package sorting;
public class leetcode215 {
    public static void main(String[] args) {
        int[] arr={3,2,1,5,6,4};
        System.out.println(findKthLargest(arr, 2));
    }
    static int findKthLargest(int[] nums, int k) {
        int count=0;
        int last=nums.length-1;
        int first=Integer.;
        while(count<k){
            int max=0;
            for(int i=0;i<=last;i++){
                max=Math.max(nums[i], max);
                swap(nums,i,last);
            }
            last--;
            count++;
        }
        return nums[last-1];
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        // int minv = nums[0];
        // int maxv = nums[0];
        // for(int i = 1; i < nums.length; i++){
        //     if (nums[i] < minv) minv = nums[i];
        //     if (nums[i] > maxv) maxv = nums[i];
        // }
        // int[] count = new int[maxv - minv + 1];
        // for(int i = 0; i < nums.length; i++) count[nums[i]-minv]++;
        // int rem = k;
        // for(int i = count.length-1; i >= 0; i--){
        //     rem -= count[i];
        //     if(rem <= 0) return i + minv;
        // }
        // return -1;
    }
    static void swap(int[] nums,int first,int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}
