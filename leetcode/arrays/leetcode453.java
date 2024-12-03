package arrays;

import java.util.HashSet;
import java.util.Set;

public class leetcode453 {
    public static void main(String[] args) {
        leetcode453 sol = new leetcode453();
        System.out.println(sol.minMoves(new int[]{-1000000000,-1}));
    }
    public int minMoves(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max,num);
            
        }
        for(int num:nums){
            if(!set.contains(num)){
                ans+=(max-num);
            }
            set.add(num);
        }
        return ans;
    }
}
