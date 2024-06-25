import java.util.ArrayList;
import java.util.List;

public class subset {
    public static void main(String[] args) {
        System.out.println(set(new int[]{1,2,4,5,3,6,1}));
    }
    public static List<List<Integer>> set (int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,ans,0,0,new ArrayList<>());
        return ans;
    }
    private static void helper(int[] nums, List<List<Integer>> ans,int st,int en,List<Integer> list) {
        if(st==nums.length){
            return;
        }
        ans.add(new ArrayList<>(list));
        if(en==nums.length){
            list.remove(0);
            helper(nums, ans, st+1, en, list);
        }else{
            list.add(nums[en]);
            helper(nums, ans, st, en+1, list);
        }
    } 
}
