package Trees;

import java.util.ArrayList;
import java.util.List;

public class leetcode863 {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node6, node2);

        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1, node0, node8);

        TreeNode root = new TreeNode(3, node5, node1);
        
        System.out.println(distanceK(root, node5, 2));
    }
    static List<Integer> ans;

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        findDistanceAndCollectNodes(root, target, k);
        return ans;
    }

    private static int findDistanceAndCollectNodes(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            collectNodesAtDistanceK(root, k);
            return 0;
        }

        int leftDistance = findDistanceAndCollectNodes(root.left, target, k);
        if (leftDistance != -1) {
            if (leftDistance + 1 == k) {
                ans.add(root.val);
            } else {
                collectNodesAtDistanceK(root.right, k - leftDistance - 2);
            }
            return leftDistance + 1;
        }

        int rightDistance = findDistanceAndCollectNodes(root.right, target, k);
        if (rightDistance != -1) {
            if (rightDistance + 1 == k) {
                ans.add(root.val);
            } else {
                collectNodesAtDistanceK(root.left, k - rightDistance - 2);
            }
            return rightDistance + 1;
        }

        return -1;
    }

    private static void collectNodesAtDistanceK(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            ans.add(root.val);
            return;
        }
        collectNodesAtDistanceK(root.left, k - 1);
        collectNodesAtDistanceK(root.right, k - 1);
    }
}

