package arrays;

import java.util.Arrays;


public class leetcode2017 {
    public static void main(String[] args) {
        int[][] grid = {
            {3, 3, 1},
            {8, 5, 2}
        };
        leetcode2017 obj = new leetcode2017();
        long result = obj.gridGame(grid);
        System.out.println("Result: " + result);
    }
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] prefix1 = new long[n];
        prefix1[0] = grid[0][0];
        long[] prefix2 = new long[n];
        prefix2[0] = grid[1][0];

        for(int j = 1;j<n;j++){
            prefix1[j] = prefix1[j-1] + grid[0][j];
            prefix2[j] = prefix2[j-1] + grid[1][j];
        }
        System.out.println(Arrays.toString(prefix1));
        System.out.println(Arrays.toString(prefix2));
        long min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            min = Math.min(min,Math.max(prefix1[n-1]-prefix1[i],i>0?prefix2[i-1]:0));
        }
        
        return min;
    }
    
}


