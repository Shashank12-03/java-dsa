package binarysearch;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode2616 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3, 2, 1, 2};
        int p = 3;
        leetcode2616 obj = new leetcode2616();
        int result = obj.minimizeMax(nums, p);
        System.out.println(result);
    }
    public int minimizeMax(int[] nums, int p) {
        // 1 2 2 2 3 3 4
        if(p==0){
            return 0;
        }
        Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<nums.length-1;i++){
            pq.add(Math.abs(nums[i]-nums[i+1]));
        }
        System.out.println(pq);
        p--;
        while(p>0){
            pq.poll();
            p--;
        }
        return pq.peek();
    }
}
