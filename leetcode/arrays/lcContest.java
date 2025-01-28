package arrays;

import java.util.*;

public class lcContest {
    public static void main(String[] args) {
        int[] arr = {-9};
        int[] brr = {9};
        long k = 29;
        lcContest contest = new lcContest();
        long result = contest.minCost(arr, brr, k);
        System.out.println("The minimum cost is: " + result);
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
}
