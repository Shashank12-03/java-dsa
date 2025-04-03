package greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class leetcode2551 {

    public static void main(String[] args) {
        leetcode2551 l = new leetcode2551();
        int[] weights = {1,4,2,5,2}; // 5 6 7 7  
        int k = 3;
        System.out.println(l.putMarbles(weights, k)); // Output: 4
    }
    public long putMarbles(int[] weights, int k) {
        long max = 0;
        long min = 0;
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<weights.length-1;i++){
            minq.add(weights[i]+weights[i+1]);
            maxq.add(weights[i]+weights[i+1]);
        }
        if (minq.size() < k || maxq.size() < k) {
            return 0;
        }
        for(int i = 0;i<k-1;i++){
            max += maxq.poll();
            min += minq.poll();
        }
        return max-min;
    }
}