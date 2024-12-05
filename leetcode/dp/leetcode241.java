package dp;

import java.util.ArrayList;
import java.util.List;

public class leetcode241 {
    public static void main(String[] args) {
        
    }
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        helper(expression,0,expression.length()-1,ans);
        return ans;
    }
    private void helper(String expression, int i, int j,List<Integer> ans) {
        if (i>j) {
            return;
        }
        for (int k = i; k <=j; k++) {
            
        }
    }
}
