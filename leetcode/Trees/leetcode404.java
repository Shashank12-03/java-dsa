package Trees;
public class leetcode404 {
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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root);
    }
    private int helper(TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum=0;
        if(root.left!=null && root.left.left==null && root.left.right==null ){
            sum+=root.left.val;
        }
        sum+=helper(root.left);
        sum+=helper(root.right);
        return sum;
    }
    
}
