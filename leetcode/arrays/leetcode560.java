package arrays;


import java.util.HashMap;

public class leetcode560 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{15,-2,2,-8,1,7,10,23}, 0));
    }
    public static int subarraySum(int[] nums, int k) {
        if(nums.length==1 && nums[0]!=k){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(sum,1);
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            count+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        // int count =0;
        // sum=0;
        // for(int i=0;i<nums.length;i++){
        //     sum+=nums[i];
        //     if(set.contains(sum-k)){
        //         count++;
        //     }
        // }
        return count;

    }
}