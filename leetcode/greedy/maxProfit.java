package greedy;

import java.util.*;
// import java.util.Map.Entry;

public class maxProfit {
    public static void main(String[] args) {
        System.out.println(maxprofit(50, new int[] {25,30}, new int[] {25,37}));
    }
    public static int maxprofit(int k,int[] cost, int[] sell){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<cost.length;i++){
            map.put(cost[i], sell[i]-cost[i]);
        }
        int current = k;
        int maxProfit = 0;
        for (int i = 0; i < cost.length; i++) {
            int profit = map.get(cost[i]);
            if (current>cost[i]){
                current -=cost[i];
                current += profit;
            }
            maxProfit = Math.max(maxProfit, current);
        }
        return maxProfit;
    }
}
