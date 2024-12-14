package dp;

import java.util.HashMap;
import java.util.Map;

public class leetcode1218 {
    public static void main(String[] args) {
        leetcode1218 sol = new leetcode1218();
        System.out.println(sol.longestSubsequence(new int[]{}, 0));
    }
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(arr[i]-difference)){
                map.put(arr[i],map.get(arr[i]-difference)+1);
            }
            else{
                map.put(arr[i],1);
            }
            max = Math.max(map.get(arr[i]),max);
            // for(int j = i-1;j>=-1;j--){
            //     int notPick =dp[i+1][j+1];/* helper(arr,prev,ind+1,difference,dp);*/
            //     int pick = 0;
            //     if(j==-1 || arr[i]==difference+arr[j]){
            //         pick = 1 +dp[i+1][i+1];/* helper(arr,ind,ind+1,difference,dp);*/
            //     }
                
            //     dp[i][j+1] = Math.max(pick,notPick);
            // }
        }
        return max; /*helper(arr,-1,0,difference,dp);*/
    }
}
