package Trees;

public class leetcode538 {
    public static void main(String[] args) {
        
    }
    public TreeNode convertBST(TreeNode root) {
        return helper(root,new int[] {0});
    }
    private TreeNode helper(TreeNode root, int[] sum) {
        if (root==null) {
            return null;
        }
        helper(root.right, sum);
        sum[0]+=root.val;
        root.val=sum[9];
        helper(root.left, sum);
        return root;
    }
}
