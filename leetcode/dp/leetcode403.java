package dp;

import java.util.*;

public class leetcode403 {
    public static void main(String[] args) {
        
    }
    public boolean canCross(int[] stones) {

        if (stones[1]>1) {
            return false;
        }
        Set<Integer> isStone = new HashSet<>();
        for(int stone:stones){
            isStone.add(stone);
        }
        int n = stones.length;
        int[][] dp = new int[n][n];
        return helper(1,0,isStone,stones,stones.length,dp);
    }
    private boolean helper(int jump,int stoneIdx, Set<Integer> isStone, int[] stones, int n,int[][]dp) {
        if (jump <= 0) {
            return false; 
        }
        if (stoneIdx == n - 1) {
            return true;
        }
        
        if (dp[jump][stoneIdx] != -1) {
            return dp[jump][stoneIdx] == 1; 
        }
        
        int stoneThere = stones[stoneIdx] + jump; 
        if (!isStone.contains(stoneThere)) {
            dp[jump][stoneIdx] = 0; 
            return false;
        }
        
        int nextIdx = Arrays.binarySearch(stones, stoneThere);
        
        if (nextIdx >= 0) {
            dp[jump][stoneIdx] = (helper(jump - 1, nextIdx, isStone, stones, n, dp) || helper(jump, nextIdx, isStone, stones, n, dp) || helper(jump + 1, nextIdx, isStone, stones, n, dp)) ? 1 : 0;
        } else {
            dp[jump][stoneIdx] = 0; // No valid stone at the jump location
        }
        
        return dp[jump][stoneIdx] == 1;
    }
}
