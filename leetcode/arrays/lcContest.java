package arrays;

import java.util.*;

public class lcContest {
    public static void main(String[] args) {
        // int[] arr = {-9};
        // int[] brr = {9};
        // long k = 29;
        lcContest contest = new lcContest();
        // long result = contest.minCost(arr, brr, k);
        // System.out.println("The minimum cost is: " + result);
        int[] nums = {1,3,2,1,5,4};
        int kValue = 2;
        int goodNumbersSum = contest.sumOfGoodNumbers(nums, kValue);
        System.out.println("The sum of good numbers is: " + goodNumbersSum);
    }
    public long minCost(int[] arr, int[] brr, long k) {
        if(Arrays.equals(arr,brr)){
            return 0;
        }
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            map1.put(arr[i],i);
            map2.put(brr[i],i);
        }
        
        long ans = 0;
        Arrays.sort(arr);
        Arrays.sort(brr);
        int times = 0;
        for(int i = 0;i<arr.length;i++){
            ans += Math.abs(arr[i]-brr[i]);
            if(Math.abs(map1.get(arr[i]) - map2.get(brr[i]))> 1){
                times++;
            }
        }
        
        return ans+ times*k;
    }
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(i-k>=0 && i+k<n){
                if(nums[i-k]<nums[i] && nums[i+k]<nums[i]){
                    sum+=nums[i];   
                }
            }
            if(i-k<0){
                if(i+k<n && nums[i+k]<nums[i]){
                    sum+=nums[i];
                }
            }
            else if(i+k>=n){
                if(i-k>=0 && nums[i-k]<nums[i]){
                    sum+=nums[i];
                }
            }
            
        }
        return sum;
    }
}
