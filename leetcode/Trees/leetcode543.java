package Trees;

public class leetcode543 {
    public static void main(String[] args) {
        
    }
    static int diameter=Integer.MIN_VALUE;
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        height(root);
        return diameter;
    }
    private static int height(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int leftheight=height(root.left);
        int rightheight=height(root.right);
        int height=leftheight+rightheight;
        diameter=Math.max(height,diameter);
        return 1+Math.max(leftheight,rightheight);
    }
    
}