package Trees;

public class childSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(6);
        root.right = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        // root.right.right.right = new TreeNode(2);
        // root.right.right.right.right = new TreeNode(1);
        // root.right.right.right.right.right = new TreeNode(1);
        // root.right.right.right.right.right.right = new TreeNode(2);
        // root.right.right.right.right.right.right.right = new TreeNode(1);
        System.out.println(isSumProperty(root));

    }
    // 7 6 1 N 5 2
    //      7
    //    6   1
    //  5   2

    // 2
    //  \
    //   1
    //    \
    //     2
    //      \
    //       1
    //        \
    //         1
    //          \
    //           2
    //            \
    //             1
    public static int isSumProperty(TreeNode root)
    {
        return helper(root)?1:0;
    }
    private static boolean helper(TreeNode root){
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
    
        // Calculate the sum of children values (consider 0 if a child is null)
        int leftValue = (root.left != null) ? root.left.val : 0;
        int rightValue = (root.right != null) ? root.right.val : 0;
    
        // Check the current node and recurse for both children
        return (root.val == leftValue + rightValue) && helper(root.left) && helper(root.right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { 
        this.val = val;
        // System.out.println();
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}