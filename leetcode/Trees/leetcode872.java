import java.util.ArrayList;

public class leetcode872 {
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<TreeNode> first=new ArrayList<>();
        ArrayList<TreeNode> second=new ArrayList<>();
        helper(root1,first);
        helper(root2,second);
        return first.equals(second);
    }
    private void helper(TreeNode root1,ArrayList<TreeNode> store) {
        if(root1==null){
            return;
        }
        if(root1.left==null && root1.right==null ){
            store.add(root1);
        }
        helper(root1.left, store);
        helper(root1.right, store);
    }
}
