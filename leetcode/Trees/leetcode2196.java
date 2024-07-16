package Trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode2196 {
    public static void main(String[] args) {
        // TreeNode root = createBinaryTree(new int[][]{{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}});
    }
    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        for (int[] des : descriptions) {
            int parentVal = des[0];
            int childVal = des[1];
            boolean isLeft = des[2] == 1;
            
            // Ensure parent node exists in the map
            nodes.putIfAbsent(parentVal, new TreeNode(parentVal));
            TreeNode parent = nodes.get(parentVal);
            
            // Ensure child node exists in the map
            nodes.putIfAbsent(childVal, new TreeNode(childVal));
            TreeNode child = nodes.get(childVal);
            
            // Set the child node as the left or right child of the parent
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            
            // Mark the child as a child node
            children.add(childVal);
        }
        
        // Find the root node (which is not a child of any other node)
        for (int key : nodes.keySet()) {
            if (!children.contains(key)) {
                return nodes.get(key);
            }
        }
        
        return null; // Should never hit this if the input is valid
    }
}
