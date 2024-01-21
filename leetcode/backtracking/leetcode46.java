package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode46 {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> ans= permute(arr);
        for(List<Integer> list: ans){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
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
            if(!istaken[i]){
                istaken[i]=true;
                currentpermutation.add(nums[i]);
                permute(nums, ans, currentpermutation, istaken);
                currentpermutation.remove(currentpermutation.size()-1);
                istaken[i]=false;
            }
        }
    }    
}

