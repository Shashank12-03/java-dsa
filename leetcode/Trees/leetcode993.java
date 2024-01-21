public class leetcode993 {
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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx=findnode(root,x);
        TreeNode yy=findnode(root,y);
        return((level(root,xx,0)==level(root,yy,0)) && (!issiblings(root,xx,yy)));
    }
    
    private boolean issiblings(TreeNode node,  TreeNode xx, TreeNode yy) {
        if(node==null){
            return false;
        }
        return (((node.left==xx && node.right==yy) || (node.left==yy && node.right==xx)) || ((issiblings(node.left, xx, yy))||(issiblings(node.right, xx, yy))));
    }
    private int level(TreeNode node, TreeNode xx, int level) {
        if(node==null){
            return 0;
        }
        if(node==xx){
            return level;
        }
        int l=level(node.left, xx, level+1);
        if(l!=0){
            return l;
        }
        return level(node.right, xx, level+1);
    }
    private TreeNode findnode(TreeNode node, int value) {
        if(node==null){
            return null;
        }
        if(node.val==value){
            return node;
        }
        TreeNode n=findnode(node.left, value);
        if(n!=null){
            return n;
        }
        return findnode(node.right, value);
    }
}
