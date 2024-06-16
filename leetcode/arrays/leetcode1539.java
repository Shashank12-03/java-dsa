package arrays;

public class leetcode1539 {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,7,11}, 5));
    }
    public static int findKthPositive(int[] nums, int k) {
        // int n = 1;
        // int i=0;
        // int count = 0;
        // while (count!=k) {
        //     if(i < arr.length && arr[i]==n){
        //         i++;
        //     }
        //     else{
        //         count++;
        //     }
        //     n++;
        // }
        // return --n;
        int low = -1 ;
        int high = nums.length ;
        while(low + 1 < high) {
            int mid = low + (high-low) / 2 ;
            int missingNumber = nums[mid] - (mid+1) ;
            if(missingNumber < k) {
                low = mid ;
            }else {
                high = mid ;
            }
        }
        return (high + k) ;
    }
}
