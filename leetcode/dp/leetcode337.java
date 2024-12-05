package dp;

import Trees.TreeNode;
// import java.util.*;
public class leetcode337 {
    public static void main(String[] args) {
        
    }
    
    
    public int rob(TreeNode root) {
        int[]list = helper(root);
        return Math.max(list[0], list[1]);
        
        // Deque<TreeNode> queue= new LinkedList<>();
        // List<Integer> list = new ArrayList<>();
        // queue.offer(root);
        // while(!queue.isEmpty()){
        //     int levelSize = queue.size();
        //     int sum = 0;
        //     for(int j =0;j<levelSize;j++){
        //         TreeNode current = queue.poll();
        //         sum+=current.val;
        //         if(current.left!=null){
        //             queue.offer(current.left);
        //         }
        //         if(current.right!=null){
        //             queue.offer(current.right);
        //         }
        //     } 
        //     list.add(sum);
        // }  
        // System.out.println(list);
        // int[] dp = new int[list.size()+1];
        // dp[0] = list.get(0);
        // if(list.size()==1){
        //     dp[1] = dp[0];
        // }
        // else{
        //     dp[1] = Math.max(dp[0],list.get(1));
        // }
        // for(int i = 2;i<list.size();i++){
        //     int notPick =dp[i-1];
        //     int pick = list.get(i) +dp[i-2];
        //     dp[i] = Math.max(notPick,pick);
        // }
        // return dp[list.size()-1];
    }
    private int[] helper(TreeNode root){
        if (root==null) {
            return new int[]{0,0}; 
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int withRoot = root.val + left[1]+right[1];
        int withOutRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{withRoot,withOutRoot};
    }
}
