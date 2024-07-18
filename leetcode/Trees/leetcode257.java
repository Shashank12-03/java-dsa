package Trees;
import java.util.ArrayList;
import java.util.List;

public class leetcode257{
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
    List<String> ans=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuffer treestring=new StringBuffer("");
        helper(root,treestring);
        return ans;
    }
    private void helper(TreeNode root,StringBuffer treestring) {
        if(root==null){
            return;
        }
        treestring.append(root.val);
        treestring.append("->");
        if(root.left==null && root.right==null){
            ans.add(treestring.toString());
        }
        helper(root.left,treestring);
        helper(root.right,treestring);
        treestring.delete(treestring.length()-2, treestring.length());
        treestring.deleteCharAt(treestring.length()-1)
    }
    
}