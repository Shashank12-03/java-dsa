package Trees;

import java.util.ArrayList;
import java.util.List;

public class leetcode144 {
    public static void main(String[] args) {
        
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(ans,root);
        inorder(ans,root);
        postorder(ans,root);
        return ans;
    }
    private void postorder(List<Integer> ans, TreeNode root) {
        if (root==null){
            return;
        }
        postorder(ans, root.left);
        postorder(ans, root.right);
        ans.add(root.val);
    }
    private void inorder(List<Integer> ans, TreeNode root) {
        if (root==null){
            return;
        }
        postorder(ans, root.left);
        ans.add(root.val);
        postorder(ans, root.right);
    }
    private void preorder(List<Integer> ans, TreeNode root) {
        if (root==null){
            return;
        }
        ans.add(root.val);
        preorder(ans, root.left);
        preorder(ans, root.right);
    }
}
