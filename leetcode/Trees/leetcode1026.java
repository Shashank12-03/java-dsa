package Trees;

public class leetcode1026 {
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
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode root, int minAncestor, int maxAncestor) {
        if (root == null) {
            return maxAncestor - minAncestor;
        }

        // Update minAncestor and maxAncestor based on the current node
        minAncestor = Math.min(minAncestor, root.val);
        maxAncestor = Math.max(maxAncestor, root.val);

        int leftDiff = helper(root.left, minAncestor, maxAncestor);
        int rightDiff = helper(root.right, minAncestor, maxAncestor);

        // Return the maximum difference from the left and right subtrees
        return Math.max(leftDiff, rightDiff);
    }
}
