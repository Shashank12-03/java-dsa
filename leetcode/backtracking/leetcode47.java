package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode47 {
    public static void main(String[] args) {
        int[] arr={1,1,2};
        List<List<Integer>> ans= permute(arr);
        for(List<Integer> list: ans){
            System.out.println(list);
        }
    }
    public static List<List<Integer>>  permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> currentpermutation= new ArrayList<>();
        boolean[] istaken=new boolean[nums.length];
        permute(nums,ans,currentpermutation,istaken);
        return ans;
    }
    private static void permute(int[] nums, List<List<Integer>> ans, List<Integer> currentpermutation,boolean[] istaken) {
        if(currentpermutation.size()==nums.length){
            ans.add(new ArrayList<>(currentpermutation));
            return;
        }
        for(int i=0;i<nums.length;i++){
            // skip when the element is already used or its duplicate is used
            if(istaken[i] || (i > 0 && nums[i] == nums[i-1] && istaken[i-1])){
                continue;
            }
            istaken[i]=true;
            currentpermutation.add(nums[i]);
            permute(nums, ans, currentpermutation, istaken);
            currentpermutation.remove(currentpermutation.size()-1);
            istaken[i]=false;
        }
    }    
}


