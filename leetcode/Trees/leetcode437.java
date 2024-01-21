package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class leetcode437 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        
    }
    // public int pathSum(TreeNode root, int targetSum) {
    //     List<Integer> path= new ArrayList<>();
    //     return helper(root,targetSum, path);
    // }
    // private int helper(TreeNode root, int targetSum, List<Integer> path) {
    //     if(root==null){
    //         return 0;
    //     }
    //     path.add(root.val);
    //     int count=0;
    //     int sum=0;
    //     ListIterator<Integer> itr=path.listIterator(path.size());
    //     while(itr.hasPrevious()){
    //         sum+=itr.previous();
    //         if(sum==targetSum){
    //             count++;
    //         }
    //     }
    //     count+=helper(root.left, targetSum, path)+helper(root.right, targetSum, path);
    //     //backtrack
    //     path.remove(path.size()-1);
    //     return count;

    // } 
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        
        return helper(root, targetSum) +
            pathSum(root.left, targetSum) +
            pathSum(root.right, targetSum);
    }

    private int helper(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.val == targetSum) {
            count++;
        }

        count += helper(root.left, targetSum - root.val);
        count += helper(root.right, targetSum - root.val);

        return count;
    }

}
