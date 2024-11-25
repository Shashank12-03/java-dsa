package dp;

import java.util.*;

public class leetcode2684 {
    public static void main(String[] args) {
        leetcode2684 sol = new leetcode2684();
        System.out.println(sol.maxMoves(new int[][]{{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}}));
    }
    int m = 0;
    int n = 0;

    public int maxMoves(int[][] grid) {
        int max = 0;
        m = grid.length;
        n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int[] num : dp) {
            Arrays.fill(num, -1);
        }

        for (int i = 0; i < grid.length; i++) {
            max = Math.max(max, helper(i, 0, 0, grid, dp));
        }
        return max==0?0:max-1;
    }

    private int helper(int row, int col, int value, int[][] grid, int[][] dp) {

        if (row < 0 || row >= m || col >= n) {
            return 0;
        }

        if (value >= grid[row][col]) {
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int moveRight = helper(row, col + 1, grid[row][col], grid, dp);
        int moveDiagonalUp = helper(row - 1, col + 1, grid[row][col], grid, dp);
        int moveDiagonalDown = helper(row + 1, col + 1, grid[row][col], grid, dp);

        return dp[row][col] = 1 + Math.max(moveRight, Math.max(moveDiagonalUp, moveDiagonalDown));
    }
}
