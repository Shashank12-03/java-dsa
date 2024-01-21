package slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class leetcode239 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1){
            return nums;
        }
        int[] ans=new int[nums.length-k+1];
        // int max=Integer.MIN_VALUE;
        // int j=0;
        // for(int i=0;i<k;i++){
        //     max=Math.max(max, nums[i]);
        // }
        // ans[j++]=max;
        // for(int i=k;i<nums.length;i++){
        //     if(max==nums[i-k]){
        //         max=Integer.MIN_VALUE;
        //         for(int a=i-k+1;a<i+1;a++){
        //             max=Math.max(nums[a],max);
        //         }
        //     }
        //     if(nums[i]>max){
        //         max=nums[i];
        //     }
        //     ans[j++]=max;
        // }
        // return ans;
        int index=0;
        Deque<Integer> que=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(!que.isEmpty() && que.peek()==i-k){
                que.poll();
            }
            while(!que.isEmpty() && nums[que.peekLast()]<nums[i]){
                que.pollLast();
            }
            que.offer(i);
            if(i>=k-1){
                ans[index++]=ans[que.peek()];
            }
        }
        return ans;
    }
}
