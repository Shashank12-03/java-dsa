package binarysearch;

import java.util.*;

public class leetcode1828 {
    public static void main(String[] args) {
        leetcode1828 sol = new leetcode1828();
        System.out.println(sol.maxFrequency(new int[]{1,2,4}, 5));
    }
    public int maxFrequency(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int len = max - min + 1;
        int[] count = new int[len];
        
        for (int num: nums) {
            count[num - min]++;
        }
        int start = 0, sum = 0, ans = 0, cnt = 0, startCnt = count[0];
        for (int i = 0; i < len; ++i) {
            sum += cnt;
            cnt += count[i];
            while (sum > k) {
                while (startCnt == 0) startCnt = count[++start];
                sum -= i - start;
                startCnt--;
                cnt--;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
    // private int countIncr(int[] nums, int pos, int k) {
    //     int sum = 1;
    //     for (int i = pos-1; i >=0; i--) {
    //         if(nums[pos]-nums[i]<=k){
    //             sum++;
    //             k = nums[pos]-nums[i];
    //         }else{
    //             break;
    //         }
    //     }
    //     return sum;
    // }
}
