package dp;
import java.util.*;
public class NinjaRun {
    public static void main(String[] args) {
        int[][]points={{1,2,5},{3,1,1},{3,3,3}};
        System.out.println(ninjaTraining(3, points));
    }
    public static int ninjaTraining(int n, int points[][]) {
        
        int[][] dp = new int[n][4];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(n-1,3,points,dp);
    }
    private static int helper(int day, int last, int[][] points, int[][] dp) {
        if(dp[day][last]!=-1){
            return dp[day][last];
        }
        if(day==0){
            int max=0;
            for (int i = 0; i <3; i++) {
                if(i!=last){
                    max=Math.max(max, points[day][i]);
                }
            }
            return dp[day][last]=max;
        }
        
        int max=0;
        for (int i = 0; i <3; i++) {
            if(i!=last){
                int point=points[day][i]+helper(day-1, i, points, dp);
                max=Math.max(max,point);
            }
        }
        return dp[day][last]= max;
    }
    
}
