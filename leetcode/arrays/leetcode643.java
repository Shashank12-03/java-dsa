package arrays;

public class leetcode643 {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{4,0,4,3,3}, 5));
    }
    public static double findMaxAverage(int[] nums, int k) {
        double sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        double avg=sum/k;
        double maxavg=avg;
        for(int i=k;i<nums.length;i++){
            sum=sum-nums[i-k]+nums[i];
            avg=(double)sum/k;
            maxavg=Math.max(maxavg, avg);
        }
        return maxavg;
    }
}
