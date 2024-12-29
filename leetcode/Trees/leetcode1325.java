package Trees;


public class leetcode1325 {
    public static void main(String[] args) {
        
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null){
            return null;
        }  
        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);
        if(root.val==target && root.left==null && root.right==null){
            return null;
        }
        return root;
    }
}
