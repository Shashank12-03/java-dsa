package Trees;

import java.util.Stack;

public class leetcode606 {
    public static void main(String[] args) {
        
    }
    public String tree2str(TreeNode root) {
        if (root==null) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        stack.add((char)root.val);

    }
    private void helper(TreeNode root, Stack<Character> stack) {
        if (root.left==null && root.right==null ) {
            stack.add(')');
            return;
        }
        if (root.left==null && root.right!=null) {
            stack.add('');
        }
        if (root.left!=null) {
            str.append("("+root.left.val);
        }
        if (root.right!=null) {
            str.append(root.right.val+")");
        }
    }
}
