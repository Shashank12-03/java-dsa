package backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode77 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans =new ArrayList<>();
        helper(1,n,k,ans,new ArrayList<>());
        return ans;
    }
    private static void helper(int ind, int n, int k, List<List<Integer>> ans, List<Integer> list) {
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<=n;i++){
            list.add(i);
            helper(i+1, n, k, ans,list);
            list.remove(list.size()-1);
        }
    }
}
