package arrays;

public class leetcode334 {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6}));
    }
    public static boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int small = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= smallest) {
                smallest = nums[i];
            } else if (nums[i] <= small) {
                small = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }
    // public static boolean increasingTriplet(int[] nums) {
    //     int smallest=Integer.MAX_VALUE;
    //     int greatest=Integer.MIN_VALUE;
    //     for (int i = 1; i < nums.length; i++) {
    //         for (int j = 0; j <i; j++) {
    //             smallest=Math.min(nums[j], smallest);
    //         }
    //         for (int j = i+1; j < nums.length; j++) {
    //             greatest=Math.max(greatest,nums[j]);
    //         }
    //         if(nums[i]>smallest && nums[i]<greatest){
    //             return true;
    //         }
    //         greatest=Integer.MIN_VALUE;
    //     }
    //     return false;
    // }
    
}
