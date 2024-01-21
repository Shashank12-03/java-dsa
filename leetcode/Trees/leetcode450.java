public class leetcode450 {
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val<key){
            root.right=deleteNode(root.right, key);
            return root;
        }
        if(root.val>key){
            root.left=deleteNode(root.left, key);
            return root;
        }
        if(root.left==null){
            TreeNode temp=root.right;
            return temp;
        }
        else if(root.right==null){
            TreeNode temp=root.left;
            return temp;
        }
        else{
            TreeNode succp=root;
            TreeNode succ=root.right;
            while(succ.left!=null){
                succp=succ;
                succ=succ.left;
            }
            if(succp!=root){
                succp.left=succ.right;
            }
            else{
                succp.right=succ.right;
            }
            root.val=succ.val;
            return root;
        }
    }
}
