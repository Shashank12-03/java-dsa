package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode347 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{-1,-1}, 1)));
        //topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length==0) {
            return nums;
        }
        Map<Integer, Integer> IntegerFrequencyMap = new HashMap<>();

        for (int  num : nums) {
            IntegerFrequencyMap.put(num, IntegerFrequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(IntegerFrequencyMap.entrySet());

        // Sort the list based on frequency in ascending order
        entryList.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));

        int[] ans= new int[k];
        int index=0;
        for (Map.Entry<Integer, Integer> entry : entryList){
            if(index<k){
                ans[index]=entry.getKey();
                index++;
            }
        }    
        return ans;
        // if(nums.length<=k){
        //     return nums;
        // }
        // if(k==1){
        //     return new int[]{nums[0]};
        // }
        // Arrays.sort(nums);
        // int[] ans= new int[k];
        // int index=0;
        // int j=0;
        // for(int i=1;i<nums.length;i++){
        //     if(index<k) {
        //         if(nums[i]!=nums[i-1]){
        //             ans[index]=nums[j];
        //             j=i;
        //             index++;
        //         }
        //     }
        // }
        // return ans;
    }
    // private static void sort(int[] nums) {
    //     int max=Arrays.stream(nums).max().getAsInt();
    //     int[] freq=new int[max+1];
    //     for(int i=0;i<nums.length;i++){
    //         freq[nums[i]]++;
    //     }
    //     int index=0;
    //     for(int i=0;i<freq.length;i++){
    //         while (freq[i]>0) {
    //             nums[index++]=i;
    //             freq[i]--;
    //         } 
    //     }
    // }
    
}
