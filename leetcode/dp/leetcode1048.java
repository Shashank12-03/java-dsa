package dp;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode1048 {
    public static void main(String[] args) {
        leetcode1048 sol = new leetcode1048();
        System.out.println(sol.longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
    }
    public int longestStrChain(String[] nums) {
        Arrays.sort(nums,Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i =0;i<n;i++){
            for(int j =0;j<i;j++){
                // int notTake =next[j+1]; /*helper(nums,prev,ind+1,dp);*/
                // int take = 0;
                if(checkPossible(nums[i],nums[j]) && dp[i]<1+dp[j]){
                    dp[i] = 1+dp[j]; /*helper(nums,ind,ind+1,dp);*/
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    private boolean checkPossible(String one,String two){
        if(one.length()!=two.length()+1) return false;
        int first = 0;
        int second = 0;
        while(first<one.length()){
            if (second < two.length() && one.charAt(first) == two.charAt(second)){
                first++;
                second++;
            }
            else{
                first++;
            }
        }
        if(first==one.length() && second==two.length()){
            return true;
        }
        return false;
    }
}
