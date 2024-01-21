package arrays;

public class leetcode713 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{2,1,4,3,5}, 10));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        //return helper(0,nums,k);
        if (k == 0){
            return 0;
        }
        int cnt = 0;
        int pro = 1;
        int i = 0;
        int sum=0;
        for (int j = 0; j < nums.length; j++) {
            sum+= nums[j];
            pro=sum*j;
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt; 
    }
    // private static int helper(int index, int[] nums, int k) {
    //     if(index>=nums.length){
    //         return 0;
    //     }
    //     int count=0;
    //     int product=1;
    //     for(int i=index;i<nums.length;i++){
    //         product=product*nums[i];
    //         if(product<k){
    //             count++;
    //         }
    //         else{
    //             break;
    //         }
    //     }
    //     return count+helper(index+1, nums, k);
    // }
}
