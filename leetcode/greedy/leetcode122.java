package greedy;

public class leetcode122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }
    public static int maxProfit(int[] prices) {
        int max_profit=0;
        for (int i = 1; i <prices.length; i++) {
            int num=prices[i]-prices[i-1];
            if (num>0) {
                max_profit+=num;
            }
        }
        return max_profit;
    }
}
