package slidingwindow;

public class leetcode1031{
    public static void main(String[] args) {
        
    }
    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int start=0;
        int end=0;
        if (firstLen>=secondLen) {
            // int sum1=sliding(nums, firstLen,start,end);
            int sum=0;
            for(int i=0;i<firstLen;i++){
                sum+=nums[i];
                end=i;
            }

            int maxsum=sum;
            for(int i=firstLen;i<nums.length;i++){
                sum=sum-nums[i-k]+nums[i];
                maxsum=Math.max(maxsum, sum);
                start=i-firstLen;
                end=i;
            }
            int sum1=0;
            for(int i=0;i<secondLen;i++){
                if(i>=start && i<=end){
                    continue;
                }
            }
            // int sum2=sliding(nums, secondLen, start, end);
        }
        else{
            int sum1=sliding(nums, secondLen,start,end);
        }
    }
    // public static int sliding(int[] nums,int k,int start,int end){
    //     int sum=0;
    //     for(int i=0;i<k;i++){
    //         sum+=nums[i];
    //         end=i;
    //     }

    //     int maxsum=sum;
    //     for(int i=k;i<nums.length;i++){
    //         sum=sum-nums[i-k]+nums[i];
    //         maxsum=Math.max(maxsum, sum);
    //         start=i-k;
    //         end=i;
    //     }
    //     return maxsum;
    // }
}