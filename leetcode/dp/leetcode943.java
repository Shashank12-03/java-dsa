package dp;

import java.util.Arrays;
import java.util.HashSet;

public class leetcode943 {
    public static void main(String[] args) {
        
    }
    public int mincostTicketsTab(int[] days, int[] costs) {
        int pos = 0;
        int max = days[days.length-1];
        int[] dp = new int[max+1];
        // Arrays.fill(dp,-1);
        dp[0] = 0;
        for (int day = 1; day <=max ; day++) {
            if(days[pos]!=day){
                dp[day] = dp[day-1]; /*helper(day-1,set,costs,dp);*/
            }
            else{
                dp[day] = Math.min(costs[0]+dp[day-1],Math.min(costs[1]+dp[Math.max(0,day-7)],costs[2]+dp[Math.max(0,day-30)]));
                pos++;
            }
            
        }
        // return helper(days[days.length-1],set,costs,dp);
        return dp[max];
    }
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        for(int day:days){
            set.add(day);
        }
        int[] dp =new int[days[days.length-1]+1];
        Arrays.fill(dp,-1);
        return helper(days[days.length-1],set,costs,dp);
    }
    private int helper(int day,HashSet<Integer> set,int[]costs,int[]dp){
        if(day<=0){
            return 0;
        }
        if(dp[day]!=-1){
            return dp[day];
        }
        if(!set.contains(day)){
            return dp[day] = helper(day-1,set,costs,dp);
        }
        return dp[day] = Math.min(costs[0]+helper(day-1,set,costs,dp),Math.min(costs[1]+helper(day-7,set,costs,dp),costs[2]+helper(day-30,set,costs,dp)));
    }
}
