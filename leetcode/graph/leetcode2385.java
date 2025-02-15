package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class leetcode2385 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(2);

        leetcode2385 solution = new leetcode2385();
        int result = solution.amountOfTime(root, 3);
        System.out.println("Amount of time: " + result);
    }
    int maxValue = 0;
    public int amountOfTime(TreeNode root, int start) {
        List<List<Integer>> adj = new ArrayList<>();
        maxValueNodes(root);
        int n =maxValue;
        for (int i = 0;i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        fillAdj(root,adj);
        System.out.println(adj);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int ans = 0;
        int[] visited = new int[n+1];
        visited[start] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int vertex = queue.poll();
                for (int node : adj.get(vertex)) {
                    if (visited[node] == 0) {
                        queue.add(node);
                        visited[node] = 1;
                    }
                }
            }
            if (!queue.isEmpty()) {
                ans++;
            }
        }
        return ans;
    }
    private void fillAdj(TreeNode root, List<List<Integer>> adj){
        if (root==null) {
            return;
        }
        if (root.left!=null) {
            adj.get(root.val).add(root.left.val);
            adj.get(root.left.val).add(root.val);
        }
        if (root.right!=null) {
            adj.get(root.val).add(root.right.val);
            adj.get(root.right.val).add(root.val);
        }
        fillAdj(root.left, adj);
        fillAdj(root.right, adj);
    }

    private void maxValueNodes(TreeNode root){
        if (root==null) {
            return ;
        }
        maxValue = Math.max(maxValue, root.val);
        maxValueNodes(root.left);
        maxValueNodes(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}