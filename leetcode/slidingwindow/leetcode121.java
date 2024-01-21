package slidingwindow;

public class leetcode121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
    public static int maxProfit(int[] prices) {
        int buy=0;
        int sell=1;
        int maxprofit=0;
        while(sell<prices.length){
            if(prices[buy]<prices[sell]){
                int profit=prices[sell]-prices[buy];
                maxprofit=Math.max(maxprofit,profit);
            }
            else{
                buy=sell;
            }
            sell++;
        }
        // for(int i=0;i<prices.length;i++){
        //     if(prices[buy]>prices[i]){
        //         buy=i;
        //     }
        // }
        // for(int i=buy;i<prices.length;i++){
        //     int profit=prices[i]-prices[buy];
        //     if(profit>=maxprofit){
        //         maxprofit=profit;
        //     }
        // }
        return maxprofit;
    }
}
