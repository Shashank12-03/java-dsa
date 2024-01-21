public class leetcode235 {
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(root==null){
        //     return null;
        // }
        // TreeNode node=root;
        // if(node==p || node==q){
        //     return node;
        // }
        // TreeNode left= lowestCommonAncestor(root.left, p, q);
        // TreeNode right= lowestCommonAncestor(root.right, p, q);
        // if(left!=null && right!=null){
        //     return node;
        // }
        // if(left==null){
        //     return right;
        // }
        // else{
        //     return left;
        // }
        if(root==null ||root==p || root==q){
            return root;
        }
        if(p.val> root.val && q.val>root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        if(p.val< root.val && q.val<root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else{
            return root;
        }
    }
}
