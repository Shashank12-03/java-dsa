package arrays;

import java.util.*;

public class leetcode2028 {
    public static void main(String[] args) {
        leetcode2028 sol = new leetcode2028();
        System.out.println(Arrays.toString(sol.missingRolls(new int[]{3,2,4,3}, 4, 2)));
    }
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0 ;
        for(int roll:rolls){
            sum+=roll;
        }
        int remainingSum = mean*(n+rolls.length)-sum;
        if(remainingSum>6*n || remainingSum<n){
            return new int[]{};
        }
        int[] ans = new int[n];
        int distributedMean = remainingSum/n;
        int mod = remainingSum%n;
        Arrays.fill(ans,distributedMean);
        for(int i =0;i<mod;i++){
            ans[i]++;
        }
        return ans;
    }
}
