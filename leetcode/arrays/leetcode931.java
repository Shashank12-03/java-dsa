package arrays;
public class leetcode931 {
    public static void main(String[] args) {
        // Example usage:
        int[][] exampleMatrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(minFallingPathSum(exampleMatrix));
    }

        // f(i, j) ->  i, j => n - 1 row

    public static int minFallingPathSum(int[][] matrix) {
        int min_sum =Integer.MAX_VALUE;
        int n = matrix.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            min_sum = Math.min(min_sum, helper(0, i, matrix, dp));
        }

        return min_sum;
    }
    private static int helper(int row, int col, int[][] matrix, int[][] dp) {
        if (col < 0 || col >= matrix.length) return 1_000_000_000;
        if (row == (matrix.length - 1)) return matrix[matrix.length - 1][col];
        if (dp[row][col] != -1) return dp[row][col];

        int left = matrix[row][col] +helper(row + 1, col - 1, matrix, dp);
        int down = matrix[row][col] +helper(row + 1, col, matrix, dp);
        int right =matrix[row][col] +helper(row + 1, col + 1, matrix, dp);

        dp[row][col] = Math.min(left, Math.min(down, right));
        return dp[row][col];
    }
    // public static void main(String[] args) {
    //     int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
    //     System.out.println(minFallingPathSum(matrix));
    // }

    // public static int minFallingPathSum(int[][] matrix) {
    //     if (matrix.length == 1) {
    //         return matrix[0][0];
    //     }
    //     int sum = 0;
    //     int min_sum = Integer.MAX_VALUE;
    //     ArrayList<ArrayList<Integer>> sum_matrix = new ArrayList<>(matrix.length + 1);
    //     for (int i = 0; i < matrix.length; i++) {
    //         sum = helper(matrix, 0, i, sum_matrix);
    //         min_sum = Math.min(min_sum, sum);
    //     }
    //     return min_sum;
    // }

    // private static int helper(int[][] matrix, int row, int col, ArrayList<ArrayList<Integer>> sum_matrix) {
    //     if (col < 0 || col >= matrix.length) {
    //         return Integer.MIN_VALUE;
    //     }
    //     if (row == matrix.length - 1) {
    //         return matrix[matrix.length - 1][col];
    //     }
    //     if (sum_matrix.size() <= row) {
    //         sum_matrix.add(new ArrayList<>());
    //     }
    //     if (sum_matrix.get(row).size() <= col) {
    //         sum_matrix.get(row).add(-1);
    //     }

    //     if (sum_matrix.get(row).get(col) != -1) {
    //         return sum_matrix.get(row).get(col);
    //     }

    //     int right = matrix[row][col] + helper(matrix, row + 1, col - 1, sum_matrix);
    //     int down = matrix[row][col] + helper(matrix, row + 1, col, sum_matrix);
    //     int left = matrix[row][col] + helper(matrix, row + 1, col + 1, sum_matrix);

    //     sum_matrix.get(row).set(col, Math.min(left, Math.min(down, right)));
    //     return sum_matrix.get(row).get(col);
    // }
    // public static void main(String[] args) {
    //     int[][] matrix={{2,1,3},{6,5,4},{7,8,9}};
    //     System.out.println(minFallingPathSum(matrix));
    // }
    // public static int minFallingPathSum(int[][] matrix) {
    //     if(matrix.length==1){
    //         return matrix[0][0];
    //     }
    //     int sum=0;
    //     int min_sum=Integer.MAX_VALUE;
    //     ArrayList<ArrayList<Integer>> sum_matrix = new ArrayList<>(matrix.length + 1);
    //     for (int i = 0; i < matrix.length; i++) {
    //         sum=helper(matrix,0,i,sum_matrix);
    //         min_sum=Math.min(min_sum, sum);
    //     }
    //     return min_sum;
    // }
    // private static int helper(int[][] matrix, int row, int col,ArrayList<ArrayList<Integer>> sum_matrix) {
    //     if(col<0 || col>=matrix.length){
    //         return Integer.MIN_VALUE;
    //     }
    //     if(row==matrix.length-1){
    //         return matrix[matrix.length-1][col];
    //     }
    //     if(sum_matrix.get(row).get(col)!=-1){
    //         return sum_matrix.get(row).get(col);
    //     }
    //     int right=matrix[row][col]+helper(matrix, row+1, col-1, sum_matrix);
    //     int down=matrix[row][col]+helper(matrix, row+1, col, sum_matrix);
    //     int left=matrix[row][col]+helper(matrix, row+1, col+1, sum_matrix);
    //         // if(col>=0){
    //         //     sum+=matrix[row][col]+helper(matrix, row+1, col-1,sum);
    //         //     sum+=matrix[row][col]+helper(matrix, row+1, col,sum);
    //         // }
    //         // if(col<matrix[0].length){
    //         //     sum+=matrix[row][col]+helper(matrix, row+1, col+1,sum);
    //         // }
    //     sum_matrix.get(row).set(col,Math.min(left,Math.min(down,right)));
    //     return sum_matrix.get(row).get(col);
    // }
}
