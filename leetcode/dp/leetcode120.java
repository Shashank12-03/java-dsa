package dp;

import java.util.*;



public class leetcode120{
    public static void main(String[] args) {
        // System.out.println(minimumTotal({{2},{3,4},{6,5,7},{4,1,8,3}}));
        // System.out.println(minimumTotal({{2},{3,4],[6,5,7],[4,1,8,3]]));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        // List<List<Integer>> dp = new ArrayList<>();
        int n = triangle.size();
        int[][] dp = new int[n][n];
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }
        for (int i = 0; i < dp.length; i++) {
            dp[n-1][i] = triangle.get(triangle.size()-1).get(i);
        }  
        for (int i = n-2; i >=0; i--) {
            for (int j = i; j >= 0 ; j--) {
                int zero = Integer.MAX_VALUE;
                if(j<triangle.get(i).size()){
                    zero =  triangle.get(i).get(j) +dp[i+1][j]; /*helper(triangle,row+1,end,last,dp);*/
                }
                int one = Integer.MAX_VALUE;
                if (j<triangle.get(i).size()){
                    one = triangle.get(i).get(j) + dp[i+1][j+1];/*helper(triangle,row+1,end,last+1,dp);*/
                }
                dp[i][j] = Math.min(zero,one);
            }
        }      
        // return helper(triangle,0,triangle.size(),0,dp);
        return dp[0][0];
    }
    // private static int helper(List<List<Integer>> triangle,int row,int end,int last, int[][] dp){
    //     if(row==end-1){
    //         return triangle.get(row).get(last);
    //     }
    //     if (dp[row][last]!=-1){
    //         return dp[row][last];
    //     }
    //     int zero = Integer.MAX_VALUE;
    //     if(last<triangle.get(row).size()){
    //         zero =  triangle.get(row).get(last) + helper(triangle,row+1,end,last,dp);
    //     }
    //     int one = Integer.MAX_VALUE;
    //     if (last<triangle.get(row).size()){
    //         one = triangle.get(row).get(last) + helper(triangle,row+1,end,last+1,dp);
    //     }
    //     return dp[row][last] = Math.min(zero,one);
    // }
}