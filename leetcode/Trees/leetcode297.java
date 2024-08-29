package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode297 {
    public static void main(String[] args) {
        
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serialize(root,str);
        System.out.println(str.toString());
        return str.toString();
    }

    private void serialize(TreeNode root, StringBuilder str) {
        if(root==null){
            str.append("null");
            str.append(',');
            return ;
        }
        str.append(String.valueOf(root.val));
        str.append(',');
        serialize(root.left, str);
        serialize(root.right,str);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] arr = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String string : arr) {
            queue.add(string);
        }
        TreeNode root = helper(queue);
        return root;
    }
    private TreeNode helper(Queue<String> queue) {
        String check = queue.poll();
        if (check.equals("null")){
            return null;
        }
        int val = Integer.parseInt(check);
        TreeNode node = new TreeNode(val);
        node.left = helper(queue);
        node.right = helper(queue);
        return node;
    }   
}
