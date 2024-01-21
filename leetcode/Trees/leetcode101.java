package Trees;

import java.util.LinkedList;
import java.util.Queue;
public class leetcode101 {
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> store= new LinkedList<>(); 
        store.offer(root.left);
        store.offer(root.right);
        while (!store.isEmpty()) {
            TreeNode left=store.poll();
            TreeNode right=store.poll();
            if(left == null && right== null){
                continue;
            }
            if(left == null || right== null){
                return false;
            }
            if(left.val!=right.val){
                return false;
            }
            store.offer(left.left);
            store.offer(right.right);
            store.offer(left.right);
            store.offer(right.left);
        }
        return true;
    }
}
