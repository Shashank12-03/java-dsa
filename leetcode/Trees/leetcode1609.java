package Trees;

import java.util.Queue;
import java.util.LinkedList;
public class leetcode1609 {
    public static void main(String[] args) {
        
    }
    public boolean isEvenOddTree(TreeNode root) {
        if (root==null) {
            return false;
        }
        if (root.val%2!=1) {
            return false;
        }
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        int level=0;
        while (!queue.isEmpty()) {
            int evenprev=Integer.MAX_VALUE;
            int oddprev=Integer.MIN_VALUE;
            int levelsize=queue.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode currentNode= queue.poll();
                // t0 check if level is odd or even
                if (level%2==0) {
                    // if level is even all elements must be odd
                    if (currentNode.val%2!=1) {
                        return false;
                    }
                    else{
                        // next element must be greater than previous
                        if (oddprev<currentNode.val) {
                            oddprev=currentNode.val;
                        }
                        else{
                            return false;
                        }
                    }
                }
                else{
                    // if level is odd all elements must be even
                    if (currentNode.val%2!=0) {
                        return false;
                    }else{
                        // next element must be smaller than previous
                        if (evenprev>currentNode.val) {
                            evenprev=currentNode.val;
                        }
                        else{
                            return false;
                        }
                    }
                }
                if (currentNode.left!=null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right!=null) {
                    queue.offer(currentNode.right);
                }
            }
            //increase the level
            level++;
            // set the value to peeks for next level
            evenprev=Integer.MAX_VALUE;
            oddprev=Integer.MIN_VALUE;
        }
        return true;
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
