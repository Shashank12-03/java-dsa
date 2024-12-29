package Trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class leetcode2471 {
    public static void main(String[] args) {
        leetcode2471 sol = new leetcode2471();
        System.out.println(sol.helper(new int[]{4,3}));
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int[] arr = new int[size];
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            ans+=helper(arr);
        }
        return ans;
    }
    private int helper(int[] arr){
        int cnt = 0;
        int[] nums = new int[arr.length];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            nums[i] = arr[i];
            map.put(arr[i],i);
        }
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            if(arr[i]!=nums[i]){
                int idx = map.get(nums[i]);
                int val = arr[i];
                arr[i] = arr[idx];
                arr[idx] = val;
                cnt++;
            }
        }
        return cnt;
    }
}
