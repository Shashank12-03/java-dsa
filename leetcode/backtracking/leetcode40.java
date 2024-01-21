package backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode40 {
    public static void main(String[] args) {
        int[] arr={10,1,2,7,6,1,5};
        List<List<Integer>> ans=combinationSum(arr, 8);
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
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(candidates[i]<=target){
                ds.add(candidates[i]);
                findcombination(i, candidates, target-candidates[i], ans, ds);
                ds.remove(ds.size()-1);
            }
        }
    }
}
