package Trees;

public class leetcode1530 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(2);

        leetcode1530 solution = new leetcode1530();
        int distance = 3;
        int result = solution.countPairs(root, distance);
        System.out.println("Number of good leaf node pairs: " + result);
    }


    public int countPairs(TreeNode root, int distance) {
        int[]ans = new int[1];
        helper(root,distance,ans);
        return ans[0];
    }
    private int[] helper(TreeNode root, int distance,int[]ans) {
        if(root==null){
            return new int[]{};
        }
        if (root.left == null && root.right == null){
            return new int[]{1};
        }
        int[] left = helper(root.left, distance,ans); // 0 0
        int[] right = helper(root.right, distance,ans); // 0 1
        for(int d1:left){
            for(int d2:right){
                if(d1 + d2 <= distance) {
                    ans[0]++;
                }
            }
        }
        int[] allCombined = new int[left.length + right.length];
        for(int i = 0; i < left.length; i++) {
            allCombined[i] = left[i] + 1; // increment distance for left child
        }
        for(int i = 0; i < right.length; i++) {
            allCombined[left.length + i] = right[i] + 1; // increment distance for right child
        }
        return allCombined;
        //        7
        //       / \
        //      1   4 
        //     /   / \
        //    6   5   3
        //             \
        //              2
    }
}
