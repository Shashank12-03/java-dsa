package Trees;

import java.util.*;

public class leetcode1530 {
    public static void main(String[] args) {
        // Creating nodes
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode root = new TreeNode(1, node2, node3);
        
        // Print the tree in pre-order to verify
        // printPreOrder(root);
        System.out.println(countPairs(root, 3));
    }

    // Helper method to print the tree in pre-order traversal
    public static void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    static int count = 0;
    public static int countPairs(TreeNode root, int distance) {
        List<Integer> ans = new ArrayList<>();
        helper(root,ans);
        System.out.println(ans);
        return 1;

    }
    private static void helper(TreeNode root, List<Integer> ans) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            ans.add(root.val);
        }
        helper(root.left, ans);
        helper(root.right, ans);
        
    }
}
