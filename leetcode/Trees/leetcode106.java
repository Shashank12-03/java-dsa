package Trees;

import java.util.Arrays;

public class leetcode106 {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0 || inorder.length==0){
            return null;
        }
        int root=postorder[postorder.length-1];
        int index=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root){
                index=i;
            }
        }
        TreeNode node= new TreeNode(root);
        node.left=buildTree(Arrays.copyOfRange(inorder, 0, index),Arrays.copyOfRange(postorder, index, postorder.length-1));
        node.right=buildTree(Arrays.copyOfRange(inorder, index+1, inorder.length),Arrays.copyOfRange(postorder, 0, index));
        return node;
    }
}
