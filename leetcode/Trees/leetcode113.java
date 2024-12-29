package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class leetcode113 {
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths= new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        helper(root,targetSum,path,paths);
        return paths;
    }
    private void helper(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> paths) {
        if(root==null){
            return;
        }
        path.add(root.val);
        if(root.val==targetSum && root.left==null && root.right==null){
            paths.add(new ArrayList<>(path));
        }
        else{
            helper(root.left, targetSum-root.val, path,paths);
            helper(root.right, targetSum-root.val, path,paths);
        }
        
        //backtrack
        path.remove(path.size()-1);
    } 
}
