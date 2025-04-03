package arrays;

import java.util.Arrays;

public class leetcode2033 {
    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {3, 4}};
        int x = 2;
        leetcode2033 obj = new leetcode2033();
        int result = obj.minOperations(grid, x);
        System.out.println("Minimum operations: " + result);
    }
    public int minOperations(int[][] grid, int x) {
        int operations = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] arr = new int[n*m];
        int k = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[k++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int mid = arr.length/2;
        for(int i = 0;i<arr.length;i++){
            int diff = Math.abs(arr[mid]-arr[i]);
            if(diff%x!=0){
                return -1;
            }
            else{
                operations += diff/x;
            }
        }
        return operations;
    }
}
