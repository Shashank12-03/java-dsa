package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode40 {
    public static void main(String[] args) {
        int[] arr={10,1,2,7,6,1,5};
        List<List<Integer>> ans=combinationSum2(arr, 8);
        System.out.println(ans);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(candidates);
        findcombination(0, candidates, target,0, ans, new ArrayList<>());
        return ans;
    }
    public static void findcombination(int index, int[] candidates,int target,int currSum, List<List<Integer>> ans, List<Integer> ds){
        if(currSum==target){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue; // Skip duplicates
            
            if (currSum + candidates[i] > target) break; // If current sum exceeds the target, break the loop

            ds.add(candidates[i]); // Include the candidate in the current combination
            findcombination(i + 1, candidates, target, currSum + candidates[i], ans, ds); // Move to the next index
            ds.remove(ds.size() - 1); // Backtrack by removing the last element
        }
    }
}
