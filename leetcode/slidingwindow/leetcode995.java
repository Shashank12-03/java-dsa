package slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode995 {
    public static void main(String[] args) {
        System.out.println(minKBitFlips(new int[] {0,0,0,1,0,1,1,0}, 3));
    }

    public static int minKBitFlips(int[] nums, int k) {
        // int cnt = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         cnt++;
        //         for (int j = 0; j < k; j++) {
        //             if (i + j < nums.length) {
        //                 nums[i + j] = 1 - nums[i + j];
        //             } else {
        //                 return -1;
        //             }
        //         }
        //     }
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         return -1;
        //     }
        // }
        // return cnt;
        Queue<Integer> queue = new LinkedList<>();
        int flipcnt=0;
        for(int i=0;i<=nums.length-k;i++){
            if(!queue.isEmpty() && queue.peek()<i-k+1){
                queue.poll();
            }
            if(queue.size()%2==nums[i]){
                queue.offer(i);
                flipcnt++;
            }
        }
        for (int i = nums.length-k+1; i < nums.length; i++) {
            if(!queue.isEmpty() && queue.peek()<i-k+1){
                queue.poll();
            }
            if (queue.size()%2==nums[i]) {
                return -1;
            }
        }
        return flipcnt;
    }
}

// The queue is used to store the indices where flips occur. For each index i
// from 0 to n-k, we check if the oldest flip is out of the range of k and
// remove it from the queue. If the parity of the length of the queue matches
// nums[i] (indicating that nums[i] needs to be flipped to become 1), we perform
// the flip by appending the index i to the queue and increment the flip count.