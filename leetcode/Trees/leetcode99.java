package Trees;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;

public class leetcode99 {
    public static void main(String[] args){
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node6, node2);

        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1, node0, node8);

        TreeNode root = new TreeNode(3, node5, node1);
        leetcode99 sol = new leetcode99();
        sol.recoverTree(root);
    }
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        if(prev!=null && prev.val>root.val){
            if(first==null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        helper(root.right);
    }
}
