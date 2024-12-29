package Trees;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode2415 {
    public static void main(String[] args) {
        
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(i%2==1){
                int left = 0;
                int right = size-1;
                while(left<right){
                    int val = queue.peekFirst().val;
                    queue.getFirst().val = queue.getLast().val;
                    queue.getLast().val = val;
                    left++;
                    right--;
                }
            }
            for(int j = 0;j<size;j++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            i++;
        }
        return root;
    }
}
