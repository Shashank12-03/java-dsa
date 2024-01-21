package backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode39 {
    public static void main(String[] args) {
        int[] arr={2,3,7,9};
        List<List<Integer>> ans=combinationSum(arr, 7);
        for(List<Integer> list:ans){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        findcombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    static void findcombination(int index, int[] candidates,int target, List<List<Integer>> ans, List<Integer> ds){
        if(index== candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[index]<=target){
            ds.add(candidates[index]);
            findcombination(index, candidates, target-candidates[index], ans,ds);
            ds.remove(ds.size()-1);
        }
        findcombination(index+1, candidates, target, ans,ds);
    }
}
