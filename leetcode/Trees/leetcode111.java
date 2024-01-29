package Trees;

public class leetcode111 {
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
    int mindepth=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        helper(root,1);
        return mindepth;
    }
    private void helper(TreeNode root,int depth) {
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            mindepth=Math.min(depth, mindepth);
            return;
        }
        helper(root.left, depth+1);
        helper(root.right, depth+1);
        
    }
    
}
