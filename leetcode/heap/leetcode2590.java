package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class leetcode2590 {
    public static void main(String[] args) {
        leetcode2590 sol = new leetcode2590();
        System.out.println(sol.maxKelements(new int[]{672579538,806947365,854095676,815137524}, 3));
    }
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int num:nums){
            pq.add(num);
        }        
        long ans = 0;
        while(k>0){
            int num = pq.poll();
            ans+=num;
            int newNum = (int)Math.ceilDiv(num, 3);
            pq.add(newNum);
            k--;
        }
        return ans;
    }
}
