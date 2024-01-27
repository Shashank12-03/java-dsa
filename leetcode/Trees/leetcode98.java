package Trees;

public class leetcode98 {
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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
        
    }
    private boolean isValidBST(TreeNode root, Integer low, Integer high) {
        if(root==null){
            return true;
        }
        if((low!=null && root.val<=low)||(high!=null && root.val>=high)){
            return false;
        }
        return isValidBST(root.right, root.val, high) && isValidBST(root.left, low, root.val);
    }
    
}
