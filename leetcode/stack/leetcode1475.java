package stack;

import java.util.Arrays;
import java.util.Stack;

public class leetcode1475 {
    public static void main(String[] args) {
        leetcode1475 sol = new leetcode1475();
        System.out.println(Arrays.toString(sol.finalPrices(new int[]{8,4,6,2,3})));
    }
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>();
        stk.push(prices[n-1]);                                 
        ans[n-1] = 0;
        for(int i = n-2;i>=0;i--){
            if(stk.isEmpty()){
                ans[i] = 0;
            }
            else{
                while(!stk.isEmpty() && stk.peek() > prices[i]){
                    stk.pop();
                }
                int price = prices[i];
                if (!stk.isEmpty()){
                    ans[i] = stk.peek();
                }
                else{
                    ans[i] = 0;
                }
                stk.push(price);
            }
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = prices[i]-ans[i];
        }
        return ans;
    }
}
