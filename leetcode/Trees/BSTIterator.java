
public class BSTIterator {
    TreeNode head;
    int pointer; 
        
    public BSTIterator(TreeNode root) {
        head = root;
        pointer = -1;
    }
    
    public int next() {
        return 0;
    }
    
    public boolean hasNext() {
        
    }
}
class TreeNode {
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

    

