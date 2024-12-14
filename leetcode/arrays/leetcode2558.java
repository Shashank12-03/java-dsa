package arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class leetcode2558 {
    public static void main(String[] args) {
        leetcode2558 sol = new leetcode2558();
        System.out.println(sol.pickGifts(new int[]{25,64,9,4,100}, 4));
    }
    public long pickGifts(int[] gifts, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int gift :gifts){
            pq.offer(gift);
        }
        while(k>0){
            int gift = pq.poll();
            pq.offer((int)Math.floor(Math.sqrt(gift)));
            k--;
        }
        while(!pq.isEmpty()){
            ans+= pq.poll();
        }
        return ans;
    }
}
