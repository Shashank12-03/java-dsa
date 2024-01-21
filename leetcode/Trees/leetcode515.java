import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode515 {
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> level= new ArrayList<>();
        if(root==null){
            return level;
        }
        int max=Integer.MIN_VALUE;
        Queue<TreeNode> store= new LinkedList<>();
        store.offer(root);
        level.add(root.val);
        while(!store.isEmpty()){
            int levelsize=store.size();
            for(int i=0;i<levelsize;i++){
                TreeNode currentnode=store.poll();
                max=Math.max(max, currentnode.val);
                if(currentnode.left!=null){
                    store.offer(currentnode.left);
                }
                if(currentnode.right!=null){
                    store.offer(currentnode.right);
                }
            }
            level.add(max);
            max=Integer.MIN_VALUE;
        }
        return level;
    }    
}
