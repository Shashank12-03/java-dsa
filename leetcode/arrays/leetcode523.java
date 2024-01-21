package arrays;

public class leetcode523 {
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23,2,6,4,7}, 6));
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i>=2 && (sum%k==0)){
                return true;
            }
        }
        return false;
    }
}
