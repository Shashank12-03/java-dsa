package Trees;

import java.util.*;

public class leetcode1110 {
    public static void main(String[] args) {
        // 1,2,3,4,5,6,7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(delNodes(root, new int[]{3,5}));
    }
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> delete = new HashSet<>();
        for (int num : to_delete) {
            delete.add(num);
        }
        helper(ans,delete,root,true);
        return ans;
    }
    //       1
    //   2       3
    //4     5  6   7
    private static TreeNode helper(List<TreeNode> ans, Set<Integer> delete, TreeNode root, boolean flag) {
        if (root == null) {
            return null;
        }
        boolean toDelete = delete.contains(root.val);
        if (flag && !toDelete) {
            ans.add(root);
        }
        root.left = helper(ans, delete, root.left, toDelete);
        root.right = helper(ans, delete, root.right, toDelete);
        return toDelete ? null : root;
    }
}
