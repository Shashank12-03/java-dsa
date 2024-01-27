package Trees;

import java.util.*;
public class leetcode662 {
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0, 1, new ArrayList<Integer>());
    }
    private int dfs(TreeNode root, int depth, int index, List<Integer> list) {
        if(root == null) {
            return 0;
        }
        if(depth == list.size()) {
            list.add(index);
        }
        int currWidth = index - list.get(depth) + 1;
        int left = dfs(root.left, depth + 1, index*2, list);
        int right = dfs(root.right, depth+1, index*2 + 1, list);
        return Math.max(currWidth, Math.max(left, right));
    }
    // public int widthOfBinaryTree(TreeNode root) {
    //     if (root == null)
    //         return 0;
    //     int max = 1;
    //     Queue<QueueNode> store= new LinkedList<>();
    //     store.offer(new QueueNode(root,0));
    //     int first = -1;
    //     int last = 0;
    //     int offset = 0;
    //     while (!store.isEmpty())
    //     {
    //         int total = store.size();
    //         for (int i = 0; i < total; i++)
    //         {
    //             QueueNode cur = store.poll();
    //             TreeNode node = cur.node;
    //             int idx = cur.index;
    //             if (first < 0)
    //             {
    //                 offset = idx;
    //                 first = 0;
    //             }
    //             last = idx - offset;

    //             if (node.left != null)
    //                 store.offer(new QueueNode(node.left, last * 2 + 1));

    //             if (node.right != null)
    //                 store.offer(new QueueNode(node.right, last * 2 + 2));
    //         }

    //         max = Math.max(max, last - first + 1);
    //         first = -1;
    //         last = 0;
    //     }
    //     return max;
    // }
    // public class QueueNode {
    //     TreeNode node;
    //     int index;

    //     public QueueNode(TreeNode node, int index) {
    //         this.node = node;
    //         this.index= index;
    //     }
    // }
}
