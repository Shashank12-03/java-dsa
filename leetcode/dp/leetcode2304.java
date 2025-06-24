package dp;

public class leetcode2304 {
    public static void main(String[] args) {
        int[][] grid = {{5,3},{4,0},{2,1}};
        int[][] moveCost = {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
        System.out.println(new leetcode2304().minPathCost(grid, moveCost));
    }
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        return helper(0,0,grid,moveCost,m,n);
        // 2,0
    }
    private int helper(int i, int j, int[][] grid, int[][] moveCost, int m, int n){
        if(i==m-1){
            return grid[0][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = 0;k<n;k++){
            min = Math.min(min,grid[i][k] + moveCost[grid[i][k]][k] + helper(i+1,k,grid,moveCost,m,n));
        }
        return min;
    }
}
