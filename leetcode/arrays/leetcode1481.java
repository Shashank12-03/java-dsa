package arrays;

import java.util.*;

public class leetcode1481 {
    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{5,5,4}, 1));
    }
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int[] node = new int[arr.length+1];
        int cnt = 0;
        int length=1;
        for (int i = 0; i < arr.length; i++) {
            if (i+1 < arr.length && arr[i] == arr[i+1]) {
                length++;
            } else {
                cnt++;
                node[length]++;
                length=1;
            }
        }
        for(int i=1;i<node.length;i++) {
            int canRemove = Math.min(k/i, node[i]);
            cnt-=canRemove;
            k-=canRemove*i;
        }
        return cnt;
    }
    // public static int findLeastNumOfUniqueInts(int[] arr, int k) {
    //     HashMap<Integer,Integer> store=new HashMap<>();
    //     for(int num:arr){
    //         store.put(num,store.getOrDefault(num,0)+1);

    //     }
    //     PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

    //     for(Map.Entry<Integer, Integer> entry : store.entrySet()) {
    //         pq.offer(entry);
    //     }
    //     //System.out.println(pq);
    //     while (k > 0 && !pq.isEmpty()) {
    //         Map.Entry<Integer, Integer> entry = pq.poll();
    //         int frequency = entry.getValue();
    //         if (frequency <= k) {
    //             k -= frequency;
    //         } else {
    //             break;
    //         }
    //     }
    //     int remaining = pq.size();

    //     return remaining + ((k > 0) ? 1 : 0);
    // }
}
