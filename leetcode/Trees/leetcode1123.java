package Trees;

public class leetcode1123 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    class Pair{
        TreeNode node;
        int height;
        Pair(TreeNode node, int height){
            this.node = node;
            this.height = height;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        leetcode1123 solution = new leetcode1123();
        TreeNode lca = solution.lcaDeepestLeaves(root);
        System.out.println("LCA of deepest leaves: " + (lca != null ? lca.val : "null"));
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair ans = helper(root);
        return ans.node;
    }
    private Pair helper(TreeNode root){
        if(root==null){
            return new Pair(null,0);
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        int leftHeight = left.height;
        int rightHeight = right.height;
        if(leftHeight==rightHeight){
            return new Pair(root,leftHeight+1);
        }
        else if(leftHeight>rightHeight){
            return new Pair(left.node, leftHeight+1);
        }
        else{
            return new Pair(right.node, rightHeight+1);
        }
    }
}

