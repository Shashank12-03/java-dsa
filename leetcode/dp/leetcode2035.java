package dp;
public class leetcode2035 {
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{91,14,16,82,32,2,38,94}));
    }
    public static int minimumDifference(int[] nums) {
        // int n = nums.length;
        // int min_ele=Integer.MAX_VALUE;
        // int[] prefix = new int[n + 1];
        // Arrays.sort(nums);
        // for (int i = 0; i < n; i++) {
        //     min_ele=Math.min(min_ele, nums[i]);
        // }
        // for (int i = 0; i < n; i++) {
        //     nums[i]+=Math.abs(min_ele);
        // }
        // for(int i = 0; i < n; i ++) {
        //     prefix[i + 1] = nums[i] + prefix[i];
        // }
        // int total = prefix[prefix.length - 1];
        // int half = n / 2;
        // int i = 0;
        // int res = Integer.MAX_VALUE;
        // for( ; half < n + 1; half++, i++){
        //     int curr = prefix[half] - prefix[i];
        //     res = Math.min(res, Math.abs(total - curr - curr));
        // }
        // return res;
        int total_sum=0;
        int min_dif=Integer.MAX_VALUE;
        int min_ele=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min_ele=Math.min(min_ele, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]+=Math.abs(min_ele);
        }
        for (int num : nums) {
            total_sum+=num;
        }
        boolean[][] dp=new boolean[nums.length][total_sum+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0]=true;
        }
        if(nums[0]<=total_sum){
            dp[0][nums[0]]=true;
        }
        for (int ind = 1; ind < nums.length; ind++) {
            for (int  target= 1; target <= total_sum; target++) {
                boolean not_take=dp[ind-1][target];
                boolean take=false;
                if (nums[ind]<=target) {
                    take=dp[ind-1][target-nums[ind]];
                }
                dp[ind][target]=take||not_take;
            }
        }
        // for (boolean[] bs : dp) {
        //     System.out.println(Arrays.toString(bs));
        // }
        for (int i = 0; i <= total_sum/2; i++) {
            if (dp[nums.length-1][i]) {
                int sum1=i;
                int sum2=total_sum-sum1;
                min_dif=Math.min(min_dif, Math.abs(sum1-sum2));
            }
        }
        return min_dif;
    }
}
