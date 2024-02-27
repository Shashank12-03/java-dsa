package Trees;

public class leetcode110 {

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(2);
        root.right= new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(3);
        root.left.left.left= new TreeNode(4);
        root.left.left.right=new TreeNode(4);
        System.out.println(isBalanced(root));

    }
    static boolean is_balanced=true;
    public static boolean isBalanced(TreeNode root) {
        if (root==null) {
            return true;
        }
        helper(root);
        return false;
    }
    private static int helper(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        int load=left-right;
        if (Math.abs(load)>1) {
            is_balanced=false;
        }
        return Math.max(left,right)+1;
    }
}

class TreeNode {
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