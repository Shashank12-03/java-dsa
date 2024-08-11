package dp;

// import java.util.*;

public class leetcode63 {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // if(obstacleGrid.length ==1 || obstacleGrid[0].length==1){
        //     return 0;
        // }
        int []prev = new int[obstacleGrid[0].length];
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }
        for (int i = 0; i < obstacleGrid.length; i++) {
            int[] curr = new int[prev.length];
            for (int j = 0; j < obstacleGrid[0].length;j++) {
                if(obstacleGrid[i][j]==1){
                    curr[j]=0;
                }
                else if(i==0 &&  j==0){
                    curr[j] = 1;
                }
                else{
                    int right=0;
                    int down  =0;
                    if (j>0){
                        right =curr[j-1];
                    }
                    if(i>0){
                        down =prev[j];
                    }
                    curr[j]=right+down;
                }
            }
            prev = curr;
        }
        return prev[obstacleGrid.length-1];
    }

    public int helper(int[][] matrix,int[][] dp,int row,int col){
        if(row>=0 && col>=0 && matrix[row][col]== 1){
            return 0;
        }
        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0){
            return 0;
        }
        if (dp[row][col]!=-1){
            return dp[row][col];
        }
        int right =helper(matrix,dp,row,col-1);
        int down =helper(matrix,dp,row-1,col);
        return dp[row][col]=right+down;
    }
}
