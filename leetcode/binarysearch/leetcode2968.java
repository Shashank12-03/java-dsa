package binarysearch;

import java.util.Arrays;

public class leetcode2968 {
    public static void main(String[] args) {
        leetcode2968 sol = new leetcode2968();
        System.out.println(sol.maxFrequencyScore(new int[]{1,2,6,4}, 3));
    }
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        int ans = 0;
        int left = 1;
        int right = n;
        while(left<=right){
            int score = left +(right-left)/2;
            if(check(score,nums,prefix,k,n)){
                ans = score;
                left = score+1;
            }
            else{
                right = score-1;
            }
        }
        return ans;
    }
    private boolean check(int mid, int[] nums,int[] prefix, long k,int n){
        int i = 0;
        int j =mid-1;
        
        while(j<n){ 
            int tarIdx = i + (j-i)/2;
            int target = nums[tarIdx];
            int leftReq  = 0;
            int rightReq  = 0;
            if(tarIdx==0){
                leftReq  = 0;
            }
            else{
                leftReq  = Math.abs((target*(tarIdx-i))-(prefix[tarIdx-1] - (i>0?prefix[i-1]:0)));
            }
            
            rightReq  = Math.abs(target*(j-tarIdx)-(prefix[j]-prefix[tarIdx]));
            if(leftReq+rightReq<=k){
                return true;
            }
            i++;
            j++;
        }
        return false;
    }
}
