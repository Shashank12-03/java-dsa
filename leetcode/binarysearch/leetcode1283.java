import java.util.Arrays;

public class leetcode1283 {
    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{44,22,33,11,1}, 5));
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int start=1;
        int end=1000000;
        while (start<=end) {
            int mid=start+(end-start)/2;
            long sum=checksum(nums, mid);
            if (sum<=threshold) {
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
    public static long checksum(int[] nums, int divisor) {
        long total=0;
        for(int i=0;i<nums.length;i++){
            total+=Math.ceil((double)nums[i]/(double)divisor);
        }
        return total;
    }
}
