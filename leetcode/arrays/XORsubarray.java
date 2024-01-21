public class XORsubarray {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{4, 2, 2, 6, 4}, 6));
    }
    public static int solve(int[] nums, int target) {
        int xor=nums[0];
        int start=0;
        int count=0;
        for(int i=1;i<nums.length;i++){
            while (start<nums.length) {
                xor=xor^nums[i];
                if(xor==target){
                    count++;
                    start=i;
                    xor=nums[start];
                }
            }
        }
        return count;
    }
}
// public static int minSubArrayLen(int target, int[] nums) {
//         int start=0;
//         int end=0;
//         int sum=0;
//         int min_length=Integer.MAX_VALUE;
//         while(end<nums.length){
//             sum+=nums[end];
//             end++;
//             while(start<end && sum>=target){
//                 sum=sum-nums[start];
//                 start++;
//                 min_length=Math.min(end-start+1, min_length);
//             }
//         }
//         if(min_length==Integer.MAX_VALUE){
//             return 0;
//         }
//         return min_length;
//     }