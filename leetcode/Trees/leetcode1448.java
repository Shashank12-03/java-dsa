public class leetcode1448 {
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
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }
    public int helper(TreeNode root, int min){
        int count=0;
        if(root==null){
            return 0;
        }
        if(min<root.val){
            count++;
        }
        count+=helper(root.left, min)+helper(root.right, min);
        return count;
    }
}
