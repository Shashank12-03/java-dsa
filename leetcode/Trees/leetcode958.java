package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode958 {
    public static void main(String[] args) {
        
    }
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean occur = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(occur && (node.left!=null || node.right!=null)){
                    return false;
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                else{
                    if(node.right!=null){
                        return false;
                    }
                    occur = true;
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                else{
                    occur = true;
                }
            }
        }
        return true;
    }
}
