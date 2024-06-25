package backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode216 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1,k,n,new ArrayList<>(),ans);
        return ans;
    }
    private static void helper(int num, int k, int n, List<Integer> list, List<List<Integer>> ans) {
        if(list.size()==k){
            if(n==0){
                ans.add(new ArrayList<>(list));
                return;
            }
        }
        for (int i = num; i <= 9; i++) {
            list.add(i);
            helper(i+1, k, n-i, list, ans);
            list.remove(list.size()-1);
        }
        // helper(num+1, k, n, list, ans);
    }
}
